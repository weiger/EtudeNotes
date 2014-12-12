#include <cr_section_macros.h>
#include <NXP/crp.h>

// Variable to store CRP value in. Will be placed automatically
// by the linker when "Enable Code Read Protect" selected.
// See crp.h header for more information
__CRP const unsigned int CRP_WORD = CRP_NO_CRP;

#include "LPC17xx.h"                        
#include "ssp.h"
#include <string.h>
#include <stdlib.h>
#include <math.h>
#include "font.h"

#define PORT_NUM			1
#define LOCATION_NUM		0

#define pgm_read_byte(addr) (*(const unsigned char *)(addr))

uint8_t src_addr[SSP_BUFSIZE];
uint8_t dest_addr[SSP_BUFSIZE];
int colstart = 0;
int rowstart = 0;

#define ST7735_TFTWIDTH  127
#define ST7735_TFTHEIGHT 159
#define ST7735_CASET   0x2A
#define ST7735_RASET   0x2B
#define ST7735_RAMWR   0x2C
#define swap(x, y) { x = x + y; y = x - y; x = x - y; }
#define GREEN 0x00FF00
#define BLACK  0x000000
#define RED  0xFF0000
#define BLUE  0x0000FF
#define WHITE  0xFFFFFF
int _height = ST7735_TFTHEIGHT;
int _width = ST7735_TFTWIDTH;
static unsigned int width = 128;
static unsigned int height = 160;
int cursor_x = 0, cursor_y = 0;
uint16_t textcolor = RED, textbgcolor = WHITE;
float textsize = 2;
int wrap = 1;

enum list_state {
	MAIN_MENU = 0,
	TEXT_SUBMENU = 1,
	GRAPHICS_SUBMENU = 2,
	DISPLAY_LINE = 3,
	DISPLAY_CIRCLE = 4,
};

enum list_state state = MAIN_MENU;

void spiwrite(uint8_t c) {
	int portnum = 0;

	src_addr[0] = c;
	SSP_SSELToggle(portnum, 0);
	SSPSend(portnum, (uint8_t *) src_addr, 1);
	SSP_SSELToggle(portnum, 1);

}
void writecommand(uint8_t c) {
	LPC_GPIO0->FIOCLR |= (0x1 << 21);
	spiwrite(c);
}
void writedata(uint8_t c) {

	LPC_GPIO0->FIOSET |= (0x1 << 21);
	spiwrite(c);
}
void writeword(uint16_t c) {

	uint8_t d;

	d = c >> 8;
	writedata(d);
	d = c & 0xFF;
	writedata(d);
}
void write888(uint32_t color, uint32_t repeat) {
	uint8_t red, green, blue;
	int i;
	red = (color >> 16);
	green = (color >> 8) & 0xFF;
	blue = color & 0xFF;
	for (i = 0; i < repeat; i++) {
		writedata(red);
		writedata(green);
		writedata(blue);
	}
}

void setAddrWindow(uint16_t x0, uint16_t y0, uint16_t x1, uint16_t y1) {

	writecommand(ST7735_CASET);
	writeword(x0);
	writeword(x1);
	writecommand(ST7735_RASET);
	writeword(y0);
	writeword(y1);

}
void drawPixel(int16_t x, int16_t y, uint16_t color) {
	if ((x < 0) || (x >= _width) || (y < 0) || (y >= _height))
		return;

	setAddrWindow(x, y, x + 1, y + 1);
	writecommand(ST7735_RAMWR);

	write888(color, 1);
}

void HLine(int16_t x0, int16_t x1, int16_t y, uint16_t color) {
	width = x1 - x0 + 1;
	setAddrWindow(x0, y, x1, y);
	writecommand(ST7735_RAMWR);
	write888(color, width);
}
void VLine(int16_t x, int16_t y0, int16_t y1, uint16_t color) {
	width = y1 - y0 + 1;
	setAddrWindow(x, y0, x, y1);
	writecommand(ST7735_RAMWR);
	write888(color, width);
}

void drawLine(int16_t x0, int16_t y0, int16_t x1, int16_t y1, uint16_t color) {
	int16_t x, y;
	float slope;
	if (x0 == x1) {
		VLine(x0, y0, y1, color);
	} else if (y0 == y1) {
		HLine(x0, x1, y0, color);
	} else {
		slope = (y1 - y0) / (x1 - x0);
		if (abs(slope) < 1) {
			for (x = x0; x < x1 + 1; x++) {
				y = (x - x0) * slope + y0;
				drawPixel(x, (y + 0.5), color);

			}
		} else {
			for (y = y0; y < y1 + 1; y++) {
				x = (y - y0) / slope + x0;
				drawPixel((x + 0.5), y, color);
			}
		}
	}
}
void drawCircle(int16_t xPos, int16_t yPos, int16_t radius, uint16_t color) {
	/*draws circle at x,y with given radius & color*/
	int x, xEnd, y;
	xEnd = (0.7071 * radius) + 1;
	for (x = 0; x <= xEnd; x++) {
		y = (sqrt(radius * radius - x * x));
		drawPixel(xPos + x, yPos + y, color);
		drawPixel(xPos + x, yPos - y, color);
		drawPixel(xPos - x, yPos + y, color);
		drawPixel(xPos - x, yPos - y, color);
		drawPixel(xPos + y, yPos + x, color);
		drawPixel(xPos + y, yPos - x, color);
		drawPixel(xPos - y, yPos + x, color);
		drawPixel(xPos - y, yPos - x, color);
	}
}

void fillrect(int16_t x0, int16_t y0, int16_t x1, int16_t y1, uint32_t color) {
	int16_t i;
	int16_t width, height;

	width = x1 - x0 + 1;
	height = y1 - y0 + 1;
	setAddrWindow(x0, y0, x1, y1);
	writecommand(ST7735_RAMWR);
	write888(color, width * height);
}

void lcddelay(int ms) {
	int count = 24000;
	int i;

	for (i = count * ms; i--; i > 0)
		;
}

void lcd_init() {
	/*
	 * portnum 	= 0 ;
	 * cs 		= p0.16 / p0.6 ?
	 * rs		= p0.21
	 * rst		= p0.22
	 */
	uint32_t portnum = 0;
	int i;
	printf("LCD Initializing....\n");
	/* Notice the hack, for portnum 0 p0.16 is used */
	if (portnum == 0) {
		LPC_GPIO0->FIODIR |= (0x1 << 16); /* SSP1, P0.16 defined as Outputs */
	} else {
		LPC_GPIO0->FIODIR |= (0x1 << 6); /* SSP0 P0.6 defined as Outputs */
	}
	/* Set rs(dc) and rst as outputs */
	LPC_GPIO0->FIODIR |= (0x1 << 21); /* rs/dc P0.21 defined as Outputs */
	LPC_GPIO0->FIODIR |= (0x1 << 22); /* rst P0.22 defined as Outputs */

	/* Reset sequence */
	LPC_GPIO0->FIOSET |= (0x1 << 22);

	lcddelay(500); /*delay 500 ms */
	LPC_GPIO0->FIOCLR |= (0x1 << 22);
	lcddelay(500); /* delay 500 ms */
	LPC_GPIO0->FIOSET |= (0x1 << 22);
	lcddelay(500); /* delay 500 ms */
	for (i = 0; i < SSP_BUFSIZE; i++) /* Init RD and WR buffer */
	{
		src_addr[i] = 0;
		dest_addr[i] = 0;
	}

	/* do we need Sw reset (cmd 0x01) ? */

	/* Sleep out */
	SSP_SSELToggle(portnum, 0);
	src_addr[0] = 0x11; /* Sleep out */
	SSPSend(portnum, (uint8_t *) src_addr, 1);
	SSP_SSELToggle(portnum, 1);

	lcddelay(200);
	/* delay 200 ms */
	/* Disp on */
	SSP_SSELToggle(portnum, 0);
	src_addr[0] = 0x29; /* Disp On */
	SSPSend(portnum, (uint8_t *) src_addr, 1);
	SSP_SSELToggle(portnum, 1);
	/* delay 200 ms */
	lcddelay(200);
}

void drawChar(int16_t x, int16_t y, unsigned char c, uint16_t color,
		uint16_t bg, uint8_t size) {

	int8_t i, j;
	if ((x >= 128) || // Clip right
			(y >= 280) || // Clip bottom
			((x + 6 * size - 1) < 0) || // Clip left
			((y + 8 * size - 1) < 0))   // Clip top
		return;

	for (i = 0; i < 6; i++) {
		uint8_t line;
		if (i == 5)
			line = 0x0;
		else
			line = pgm_read_byte(font + (c * 5) + i);
		for (j = 0; j < 8; j++) {
			if (line & 0x1) {
				if (size == 1) // default size
					drawPixel(x + i, y + j, color);
				else {  // big size
					fillrect(x + (i * size), y + (j * size),
							size + x + (i * size), size + y + (j * size),
							color);
				}
			} else if (bg != color) {
				if (size == 1) // default size
					drawPixel(x + i, y + j, bg);
				else {  // big size
					fillrect(x + i * size, y + j * size, (size + x + i * size),
							(size + y + j * size), bg);
				}
			}
			line >>= 1;
		}
	}
}
void write(uint8_t c) {

	if (c == '\n') {
		cursor_y += textsize * 8;
		cursor_x = 0;
	} else if (c == '\r') {
		// skip em
	} else {
		drawChar(cursor_x, cursor_y, c, textcolor, textbgcolor, textsize);
		cursor_x += textsize * 6;
		if (wrap && (cursor_x > (_width - textsize * 6))) {
			cursor_y += textsize * 8;
			cursor_x = 0;
		}
	}
}

void writestring(char *str, int x, int y, uint16_t tcolor, uint16_t bgcolor,
		float tsize) {
	char c;
	cursor_x = x;
	cursor_y = y;
	textcolor = tcolor;
	textbgcolor = bgcolor;
	textsize = tsize;
	while (*str != NULL) {
		c = *str++;
		write(c);
	}

}
void display_main_menu(void) {
	fillrect(0, 0, ST7735_TFTWIDTH, ST7735_TFTHEIGHT / 3, BLACK);
	writestring("Text", 0, 0, BLACK, GREEN, 2);

	fillrect(0, ST7735_TFTHEIGHT / 3, ST7735_TFTWIDTH, ST7735_TFTHEIGHT * 2 / 3,
	BLACK);
	writestring("Line", 0, 60, BLACK, GREEN, 2);

	fillrect(0, ST7735_TFTHEIGHT * 2 / 3, ST7735_TFTWIDTH, ST7735_TFTHEIGHT,
	BLACK);
	writestring("Circle", 0, 120, BLACK, GREEN, 2);

	return;
}

void display_graphics_submenu(void) {
	fillrect(0, 0, ST7735_TFTWIDTH, ST7735_TFTHEIGHT / 3, BLACK);
	writestring("1:LINE", 0, 0, BLACK, GREEN, 2);
	fillrect(0, ST7735_TFTHEIGHT / 3, ST7735_TFTWIDTH, ST7735_TFTHEIGHT * 2 / 3,
	BLACK);
	writestring("2:CIRCLE", 0, 60, BLACK, GREEN, 2);
	//fillrect(0, ST7735_TFTHEIGHT*1/2, ST7735_TFTWIDTH, ST7735_TFTHEIGHT*3/4, BLUE);
	//writestring("3 -> IMAGE",0,80,BLACK,BLUE,2);
	fillrect(0, ST7735_TFTHEIGHT * 2 / 3, ST7735_TFTWIDTH, ST7735_TFTHEIGHT,
	BLACK);
	writestring("3:RETURN", 0, 120, BLACK, GREEN, 2);
	return;
}
void display_circle(void) {
	fillrect(0, 0, ST7735_TFTWIDTH, ST7735_TFTHEIGHT, BLACK);
	drawCircle(60, 78, 45, GREEN);
}
void display_line(void) {
	fillrect(0, 0, ST7735_TFTWIDTH, ST7735_TFTHEIGHT, BLACK);
	drawLine(10, 10, 80, 140, GREEN);
}
void display_text_submenu(void) {
	fillrect(0, 0, ST7735_TFTWIDTH, ST7735_TFTHEIGHT, BLACK);
	writestring("009411402 Xiaomeng Yi", 0, 0, GREEN, BLACK, 2);
	return;
}
void pin1_pressed(void) {
	switch (state) {
	case MAIN_MENU:
		state = GRAPHICS_SUBMENU;
		display_graphics_submenu();
		break;
	case GRAPHICS_SUBMENU:
		state = DISPLAY_CIRCLE;
		display_circle();
		break;
	}
	return;
}
void pin2_pressed(void) {
	switch (state) {
	case MAIN_MENU:
		state = TEXT_SUBMENU;
		display_text_submenu();
		break;
	case GRAPHICS_SUBMENU:
		state = DISPLAY_LINE;
		display_line();
		break;
	}
	return;
}
void pin3_pressed(void) {

}
void pin4_pressed(void) {
	switch (state) {

	case MAIN_MENU:
		return;
	case GRAPHICS_SUBMENU:
		state = MAIN_MENU;
		display_main_menu();
		break;
	case TEXT_SUBMENU:
		state = MAIN_MENU;
		display_main_menu();
		break;
	case DISPLAY_LINE:
		state = GRAPHICS_SUBMENU;
		display_graphics_submenu();
		break;
	case DISPLAY_CIRCLE:
		state = GRAPHICS_SUBMENU;
		display_graphics_submenu();
		break;
	}
	return;
}


/******************************************************************************
 **   Main Function  main()
 ******************************************************************************/
int main(void) {
	uint32_t i, portnum = PORT_NUM;

	portnum = 0; /* For LCD use 0 */
	/* SystemClockUpdate() updates the SystemFrequency variable */
	SystemClockUpdate();
	if (portnum == 0)
		SSP0Init(); /* initialize SSP port */
	else if (portnum == 1)
		SSP1Init();
	for (i = 0; i < SSP_BUFSIZE; i++) {
		src_addr[i] = (uint8_t) i;
		dest_addr[i] = 0;
	}
	lcd_init();
	fillrect(0, 0, ST7735_TFTWIDTH, ST7735_TFTHEIGHT, BLACK);
	writestring("CMPE 240\nXiaomeng\n009411402\nPush Button for switching", 0, 0, GREEN, BLACK, 2);
	lcddelay(3000);
	//display_main_menu();
	//loop_gpio();
	while(1){
		EINTInit();
	}
	return 0;
}

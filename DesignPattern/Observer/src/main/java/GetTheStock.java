package Observer;

import java.text.DecimalFormat;

public class GetTheStock implements Runnable {
    private String stock;
    private double price;

    private Subject stockGrabber;

    public GetTheStock(Subject stockGrabber, String newStock, double newPrice) {
        this.stockGrabber = stockGrabber;
        this.stock = newStock;
        this.price = newPrice;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double randNum = (Math.random() * (0.6)) - 0.3;

            DecimalFormat df = new DecimalFormat("#.##");
            price = price + price * randNum;

            if (stock.equals("IBM")) {
                ((StockGrabber) stockGrabber).setIBMPrice(price);
            }
            if (stock.equals("AAPL")) {
                ((StockGrabber) stockGrabber).setAAPLPrice(price);
            }
            if (stock.equals("GOOG")) {
                ((StockGrabber) stockGrabber).setGOOGPrice(price);
            }
            System.out.println(stock + " changed: " + df.format((price)) +
                    " " + df.format(randNum * 100) + "%");
        }
    }

}

package POJ;//Don't forget remove this

import java.util.Scanner;

public class Main {
    private int h[][] = new int[101][101];
    private int m[][] = new int[101][101];
    private int R, C;

    private void init() {
        Scanner cin = new Scanner(System.in);
        R = cin.nextInt();
        C = cin.nextInt();
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                h[i][j] = cin.nextInt();
                m[i][j] = -1;
            }
        }
    }

    public int getHeight(int x, int y) {
        if (m[x][y] != -1) {
            return m[x][y];
        }
        int max = 0;
        int tmp = 0;
        if (x > 1) {
            if (h[x][y] > h[x - 1][y]) {
                tmp = getHeight(x - 1, y);
                max = Math.max(tmp, max);
            }
        }
        if (y > 1) {
            if (h[x][y] > h[x][y - 1]) {
                tmp = getHeight(x, y - 1);
                max = Math.max(tmp, max);
            }
        }
        if (x < R) {
            if (h[x][y] > h[x + 1][y]) {
                tmp = getHeight(x + 1, y);
                max = Math.max(tmp, max);
            }
        }
        if (y < C) {
            if (h[x][y] > h[x][y + 1]) {
                tmp = getHeight(x, y + 1);
                max = Math.max(tmp, max);
            }
        }
        m[x][y] = max + 1;
        return m[x][y];
    }

    public int getMaxHeight() {
        int max = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                tmp = getHeight(i, j);
                max = Math.max(max, tmp);
            }
        }
        return max;
    }

    public static void main(String args[]) {
        Main m = new Main();
        m.init(); 
        System.out.println(m.getMaxHeight());
    }
}

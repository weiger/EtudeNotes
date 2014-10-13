//http://hihocoder.com/problemset/problem/1037
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int t = 0, j = 0, y = 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; ++i)
            for (t = j = 0; j < i; ++j) {
                int x = cin.nextInt();
                y = dp[j];
                dp[j] = (y > t ? y : t) + x;
                t = y;
            }
            int res = 0;
            for (int x : dp) {
                res = Math.max(res, x);
            }
            System.out.println(res);
        }
    }

//http://hihocoder.com/problemset/problem/1037
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] dp = new int[n];
        for(int i=1;i<=n;i++){
            for(int j=0,t=0;j<i;j++){
                int x = cin.nextInt();
                int tmp = dp[j];
                dp[j] = Math.max(t, dp[j]) + x;
                t = tmp;
            }
        }
        int res = 0;
        for(int i=0;i<n;i++)
            res = Math.max(res, dp[i]);
        System.out.print(res);
    }
}



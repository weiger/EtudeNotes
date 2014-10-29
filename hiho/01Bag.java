import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int sum = cin.nextInt();
        int[] need = new int[n];
        int[] value = new int[n];
        for(int i=0;i<n;i++){
            need[i] = cin.nextInt();
            value[i] = cin.nextInt();
        }
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=sum;i++)
            dp[0][i] = 0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(j<need[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j-need[i-1]]+value[i-1], dp[i-1][j]);
            }
        }
        System.out.println(dp[n][sum]);
    }
}

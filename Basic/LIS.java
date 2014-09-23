/*LIS(Longest Increasing Subsequence)
例如有一个序列:1  7  3  5  9  4  8,它的最长上升子序列就是 1 3 4 8 长度为4.
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static int LIS1(int[] data) {
        int[] dp = new int[data.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int max = 0;
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }

    public static int LIS2(int[] data) {
        int[] dp = new int[data.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int max = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] > data[i])
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            }
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }

    public static int LIS3(int[] data) {
        int[] helper = new int[data.length];
        int k = 0;
        helper[0] = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] >= helper[k])
                helper[++k] = data[i];
            else {
                int pos = binarySearch(data, data[i], k);
                helper[pos] = data[i];
            }
        }
        return k + 1;
    }

    public static int binarySearch(int[] data, int num, int k) {
        int beg = 0;
        int end = k;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (num >= data[mid])
                beg = mid + 1;
            else
                end = mid - 1;
        }
        return beg;
    }

    public static void main(String[] args) {
        int[] data = { 1, 7, 3, 5, 9, 4, 8 };
        int res = LIS3(data);
        System.out.println(res);
    }
}

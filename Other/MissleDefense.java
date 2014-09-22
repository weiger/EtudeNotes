/*
某国为了防御敌国的导弹袭击，发展出一种导弹拦截系统。但是这种导弹拦截系统有一个缺陷：虽然它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能高于前一发的高度。某天，雷达捕捉到敌国的导弹来袭。由于该系统还在试用阶段，所以只有一套系统，因此有可能不能拦截所有的导弹。
输入格式

输入数据为两行，
第一行为导弹的数目N(n<=1000)
第二行导弹依次飞来的高度，所有高度值均为不大于30000的正整数。
输出格式

输出只有一行是这套系统最多能拦截的导弹数和要拦截所有导弹最少要配备这种导弹拦截系统的套数。两个数据之间用一个空格隔开.
样例输入


8
389 207 155 300 299 170 158 65
样例输出

6 2

*/
public class Solution {
    public static int[] Missle(int[] data) {
        int[] res = new int[2];
        int len = data.length;
        int[] dp = new int[len];
        //求最长递减子序列 ,注意是数列里面的最大长度
        for (int i = 0; i < len; i++)
            dp[i] = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j > i; j--) {
                if (data[i] > data[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] > res[0])
                res[0] = dp[i];
        }
        //求最长非降子序列 ,注意是数列里面的最大长度
        for (int i = 0; i < len; i++)
            dp[i] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (data[j] <= data[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);

            }
            if (dp[i] > res[1])
                res[1] = dp[i];
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] data = { 389, 207, 155, 300, 299, 170, 158, 65 };
        int[] res = Missle(data);
        System.out.println(res[0] + " " + res[1]);
    }
}

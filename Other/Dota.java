/*http://ac.jobdu.com/problem.php?pid=1494
时间限制：1 秒内存限制：128 兆特殊判题：否提交：612解决：142
题目描述：
大家都知道在dota游戏中，装备是对于英雄来说十分重要的要素。
英雄们不仅可以购买单个的装备，甚至某些特定的装备组合能够合成更强的装备。
为了简化问题，我们将每个装备对于英雄的功能抽象为一个整数：价值。同时，如上所说，一些特定的装备可以用来合成更强的装备，玩家会因此获得除原装备价值外额外的价值。
给定玩家现有的金钱数，每个装备的价格和其对应的价值，以及装备合成的信息。输出，其能获得的最大价值数。
注意：每件装备只能参与合成一件合成装备（即原装备参与合成后得到合成后的新装备，原装备消失），除非一次购买多个该种装备。
输入：
输入包含多组测试数据，每组测试数据第一行为三个整数n，m，g(1<=n<=100),(0<=m<=100),(1<=g<=1000)。
分别表示存在的装备总数n，存在的装备合成关系数m，和英雄所有的金钱g。
接下去n行，每行两个整数（p，v）（1<=p<=100,1<=v<=100）分别表示该件装备的价格p，和其自身的价值v。
每组测试数据的最后为m行数据，每行由两部分组成。开头一个整数t(1<=t<=n)，表示该组合成关系中需要t件装备，下去紧跟t件装备编号（按照装备在输入中的顺序从1到n编号），表示参与合成该装备的装备编号，最后一个数s（1<=s<=1000），代表这t件物品合成道具后获得的额外价值。
输出：
对于每组测试数据，输出一个整数，代表英雄可以获得的最大价值。
样例输入：
3 1 100
100 20
50 9
50 9
2 2 3 1
3 1 100
100 20
50 9
50 9
2 2 3 3
样例输出：
20
21
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    /*
     * 1494
     */
    public static void main(String[] args) throws Exception {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(
            new InputStreamReader(System.in)));
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) st.nval;
            st.nextToken();
            int m = (int) st.nval;
            st.nextToken();
            int g = (int) st.nval;
            int size = n + 1 + m;
            int p[] = new int[size];
            int v[] = new int[size];
            for (int i = 1; i < n + 1; i++) {
                st.nextToken();
                p[i] = (int) st.nval;
                st.nextToken();
                v[i] = (int) st.nval;
            }
            for (int i = n + 1; i < size; i++) {
                st.nextToken();
                int t = (int) st.nval;
                for (int j = 1; j < t + 1; j++) {
                    st.nextToken();
                    int seq = (int) st.nval;
                    p[i] += p[seq];
                    v[i] += v[seq];
                }
                st.nextToken();
                int s = (int) st.nval;
                v[i] += s;
            }
            int dp[] = new int[g + 1];
            for (int i = 1; i < size; i++) {
                for (int j = p[i]; j <= g; j++) {
                    dp[j] = Math.max(dp[j], dp[j - p[i]] + v[i]);
                }
            }
            System.out.println(dp[g]);
        }
    }
}

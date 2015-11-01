/*

  1         3     3      2      1
  \       /     /      / \      \
   3     2     1      1   3      2
  /     /       \                 \
  2     1         2                 3
 
  Example: n = 3 node: 1 2 3
  res[3] = 1*(23) + (1)*2*(3) + (12)*3
  res[3] = res[0] * res[2] + res[1] * res[1] + res[2] * res[0]           

  Example: n = 4 node: 1 2 3 4
  res[4] = 1*(234) + (1)*2*(34)+(12)*3*(4) + (123)*4  -- 0*(1234) (1234)*0 impossible null can't be root 
  res[4] = res[0] * res[3] + res[1]*res[2] + res[2]*[1] + res[3]*[0];
  res[0],res[1] repsents only one node
*/
public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
public class Solution {
    public int numTrees(int n) {
        if(n == 0 || n == 1)
            return 1;
        int num = 0;
        for(int i = 0; i < n; i++) 
            num += numTrees(i) * numTrees(n - 1 - i);
        return num;
    }
}

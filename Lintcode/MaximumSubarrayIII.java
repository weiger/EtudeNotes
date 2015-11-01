public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(ArrayList<Integer> nums, int k) {
        // write your code
        if (nums == null || nums.size() < k) {
            return 0;
        }
        int len = nums.size();
        int[][] dp = new int[k + 1][len + 1];
        for (int i = 1; i <= k; i++) {
            int cur = Integer.MIN_VALUE;
            for (int j = i - 1; j < len; j++) {
                cur = Math.max(cur, dp[i - 1][j]) + nums.get(j);
                if (j == i - 1) {
                    dp[i][j + 1] = cur;
                } else {
                    dp[i][j + 1] = Math.max(dp[i][j], cur);
                }
            }
        }
        return dp[k][len];
    }
}

/*
Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Example
For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3

For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4
*/

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for(int i=0;i<len;i++){
            dp[i] = 1;
        }
        int max = 0;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>=nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}


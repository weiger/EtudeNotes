public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int oldmax = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(oldmax * nums[i], min * nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}

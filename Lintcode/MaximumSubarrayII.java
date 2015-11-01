public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code
        if (nums == null || nums.size() <= 1) {
            return 0;
        }
        int len = nums.size();
        int[] left = new int[len];
        int[] right = new int[len];
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            cur += nums.get(i);
            max = Math.max(cur, max);
            if (cur < 0) {
                cur = 0;
            }
            left[i] = max;
        }
        cur = 0;
        max = Integer.MIN_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            cur += nums.get(i);
            max = Math.max(cur, max);
            if (cur < 0) {
                cur = 0;
            }
            right[i] = max;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i + 1 < len; i++) {
            res = Math.max(res, left[i] + right[i + 1]);
        }
        return res;
    }
}

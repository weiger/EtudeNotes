public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0 ; i < nums.length; i++) {
            int beg = i + 1;
            int end = nums.length - 1;
            while (beg < end) {
                int sum = nums[i] + nums[beg] + nums[end];
                if (sum >= target) {
                    end--;
                } else {
                    cnt += (end - beg);
                    beg++;
                }
            }
        }
        return cnt;
    }
}

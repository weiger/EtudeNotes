public class Solution {
    public int threesumless(int[] nums, int target) {
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
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 6};
        int[] B = {1, 2, 3, 4, 4, 6};
        int[] C = {1, 1, 2, 3, 4, 6};
        int[] D = {1, 2, 3, 4, 6};
        System.out.println(new Solution().threesumless(A, 8));
        System.out.println(new Solution().threesumless(B, 8));
        System.out.println(new Solution().threesumless(C, 8));
    }
}

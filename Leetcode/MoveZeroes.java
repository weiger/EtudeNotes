public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int cur = 0;
        for (int i = 0 ; i < nums.length; i++){
            if (nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[cur];
                nums[cur] = tmp;
                cur++;
            }
        }
    }
}

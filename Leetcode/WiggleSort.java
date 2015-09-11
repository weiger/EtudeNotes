public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        boolean increase = true;
        for(int i = 0 ; i < nums.length - 1; i++){
            if(increase && nums[i] > nums[i + 1] || !increase && nums[i] < nums[i + 1]){
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
            increase = !increase;
        }
    }
}

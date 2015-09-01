public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if(nums.length <= 1){
            return nums;
        }
        int i = nums.length - 2;
        for(; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                break;
            }else if(i == 0){
                reverse(nums, 0, nums.length - 1);
                return nums;
            }
        }
        int j = nums.length - 1;
        for(; j > i; j--){
            if(nums[j] > nums[i]){
                break;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        reverse(nums, i + 1, nums.length - 1);
        return nums;
    }

    public void reverse(int[] nums, int beg, int end){
        while(beg < end){
            int tmp = nums[beg];
            nums[beg] = nums[end];
            nums[end] = tmp;
            beg++; end--;
        }
    }
}

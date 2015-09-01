public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int cnt = 1;
        int index = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1] && cnt < 2){
                nums[index++] = nums[i];
                cnt++;
            }else if(nums[i] != nums[i - 1]){
                nums[index++] = nums[i];
                cnt = 1;
            }
        }
        return index;
    }
}

/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int idx = 1;
        int cnt = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1] && cnt < 2){
                nums[idx++] = nums[i];
                cnt++;
            }else if (nums[i] != nums[i - 1]){
                nums[idx++] = nums[i];
                cnt = 1;
            }
        }
        return idx;
    }
}

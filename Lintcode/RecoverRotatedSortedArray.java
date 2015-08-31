public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        for(int i = 0 ; i < nums.size() - 1; i++){
            if(nums.get(i) > nums.get(i + 1)){
                reverse(nums, 0, i);
                reverse(nums, i + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
            }
        }
    }
    
    public void reverse(ArrayList<Integer> nums, int beg, int end){
        while(beg < end){
            int tmp = nums.get(beg);
            nums.set(beg, nums.get(end));
            nums.set(end, tmp);
            beg++; end--;
        }
    }
}

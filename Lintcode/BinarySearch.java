class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        int beg = 0;
        int end = nums.length - 1;
        while(beg <= end){
            int mid = beg + (end - beg) / 2;
            if(nums[mid] == target){
                end = mid - 1;
            }else if(nums[mid] < target){
                beg = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }
        }
        if(nums[beg] == target){
            return beg;
        }else{
            return -1;
        }
    }
}

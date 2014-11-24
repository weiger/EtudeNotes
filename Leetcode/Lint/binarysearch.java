/*Binary search is a famous question in algorithm.

For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

If the target number does not exist in the array, return -1.

Example
If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.*/
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        int beg = 0;
        int end = nums.length-1;
        while(beg<=end){
            int mid = beg + (end-beg)/2;
            if(nums[mid]>=target){
                end = mid - 1;
            }else{
                beg = mid + 1;
            }
        }
        if(nums[beg]==target)
            return beg;
        else
            return -1;
    }
}

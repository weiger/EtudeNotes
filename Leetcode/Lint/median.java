/*
Given a unsorted array with integers, find the median of it. 

A median is the middle number of the array after it is sorted. 

If there are even numbers in the array, return the N/2-th number after sorted.

Example
Given [4, 5, 1, 2, 3], return 3

Given [7, 9, 4, 5], return 5
*/
//O(n)
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        Arrays.sort(nums);
        int len = nums.length;
        if(len % 2 == 1){
            return nums[len/2];
        }else{
            return nums[len/2 - 1];
        }
    }
}

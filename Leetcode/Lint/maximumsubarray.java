/*
Given an array of integers, find a contiguous subarray which has the largest sum.

Note
The subarray should contain at least one number

Example
For example, given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        int res = Integer.MIN_VALUE;
        int tmp = 0;
        for(int i=0;i<nums.size();i++){
            tmp += nums.get(i);
            res = Math.max(res,tmp);
            if(tmp<0){
                tmp=0;
            }
        }
        return res;
    }
}

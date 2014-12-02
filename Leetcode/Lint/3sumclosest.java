/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. 

Note
You may assume that each input would have exactly one solution.

Example
For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        if(numbers==null || numbers.length<3)
            return 0;
        Arrays.sort(numbers);
        int res = numbers[0] + numbers[1] + numbers[2];
        for(int i=0;i<numbers.length-1;i++){
            int left = i + 1;
            int right = numbers.length - 1;
            while(left<right){
                int sum = numbers[i] + numbers[left] + numbers[right];
                if(sum==target)
                    return target;
                else if(sum<target)
                    left++;
                else if(sum>target)
                    right--;
                if(Math.abs(sum-target)<Math.abs(res-target))
                    res = sum;
            }
        }
        return res;
    }
}

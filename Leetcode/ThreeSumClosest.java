/*
 * Given an array S of n integers, find three integers in S such that 
 * the sum is closest to a given number, target. Return the sum of the 
 * three integers. You may assume that each input would have exactly 
 * one solution.

 *     For example, given array S = {-1 2 1 -4}, and target = 1.

 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num==null || num.length<3)
            return 0;
        int res = num[0] + num[1] + num[2];
        Arrays.sort(num);
        for(int i = 0;i<num.length-1;i++){
            int left = i + 1;
            int right = num.length - 1;
            while(left<right){
                int sum = num[i] + num[left] + num[right];
                if(sum==target)
                    return target;
                else if(sum>target)
                    right--;
                else if(sum<target)
                    left++;
                    
                if(Math.abs(sum - target)<Math.abs(res-target))
                    res = sum;
            }
        }
        return res;
    }
}

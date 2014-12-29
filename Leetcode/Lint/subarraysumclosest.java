/*
Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]
Challenge
O(nlogn) time
*/
//WA
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);res.add(0);
        if(nums == null || nums.length == 0)
            return res;
        int len = nums.length;
        ArrayList<Integer> sum = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        sum.add(0);
        map.put(0,0);
        for(int i = 1; i <= len; i++){
            sum.add(sum.get(i - 1)+ nums[i - 1]) ;
            map.put(sum.get(i),i);
        }
        Collections.sort(sum);
        int best = Integer.MAX_VALUE;
        for(int i = 1; i < sum.size();i++){
            int cur = sum.get(i) - sum.get(i - 1);
            if(cur < best){
                best = cur;
                res.set(0,Math.min(map.get(sum.get(i)),map.get(sum.get(i - 1))));
                res.set(1,Math.max(map.get(sum.get(i)),map.get(sum.get(i - 1))) - 1);
            }
        }
        return res;
    }
}


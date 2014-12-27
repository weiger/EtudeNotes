/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Example
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Clarification
Your algorithm should run in O(n) complexity.
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int x: num)
            set.add(x);
        int res = 1;
        for(int x: num){
            res = Math.max(res,helper(set,x,false) + helper(set,x + 1,true));
        }
        return res;
    }
    public int helper(HashSet<Integer> set,int val,boolean asc){
        int max = 0;
        while(set.contains(val)){
            max++;
            set.remove(val);
            if(asc)
                ++val;
            else
                --val;
        }
        return max;
    }
}

/*
Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

Find it.

Note
There is only one majority number in the array

Example
For [1, 2, 1, 2, 1, 3, 3] return 1

Challenge
O(n) time and O(1) space
*/
//O(n) time O(n) space
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int len = nums.size();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int x: nums){
            if(!map.containsKey(x)){
                map.put(x,1);
            }else{
                map.put(x,map.get(x) + 1);
            }
        }
        for(int x:map.keySet()){
            if(map.get(x) > len / 3)
                return x;
        }
        return -1;
    }
}


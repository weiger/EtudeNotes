/*
Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

Example
For [1, 1, 1, 1, 2, 2, 2], return 1
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int e:nums){
            if(!map.containsKey(e)){
                map.put(e,1);
            }else{
                map.put(e,map.get(e)+1);
            }
        }
        int res = 0;
        int key = 0;
        for(int e:map.keySet()){
            if(map.get(e)>res){
                res = map.get(e);
                key = e;
            }
        }
        return key;
    }
}

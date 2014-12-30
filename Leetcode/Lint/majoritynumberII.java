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

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int ans1 = 0;
        int ans2 = 0;
        int t1 = 0;
        int t2 = 0;
        for(int x:nums){
            if( t1 > 0 && x == ans1){
                t1 ++;
            }else if( t2 > 0 && x == ans2){
                t2 ++;
            }else if( t1 == 0){
                t1 = 1;
                ans1 = x;
            }else if( t2 == 0){
                t2 = 1;
                ans2 = x;
            }else{
                t1 --;
                t2 --;
            }
        }
        t1 = 0;
        t2 = 0;
        for(int x:nums){
            if( x == ans1){
                t1 ++;
            }
            else if( x == ans2){
                t2 ++;
            }
        }
        return t1 > t2 ? ans1 : ans2;
    }
}



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


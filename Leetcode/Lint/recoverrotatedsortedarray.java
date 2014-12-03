/*
Given a rotated sorted array, recover it to sorted array in-place.

Example
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

Challenge Expand 
In-place, O(1) extra space and O(n) time.

Clarification Expand 
What is rotated array:
- For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
*/

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if(nums==null || nums.size()==0)
            return;
        ArrayList<Integer> tmp1 = new ArrayList<Integer>();
        int max = nums.get(0);
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)>=max){
                tmp1.add(nums.get(i));
                max = nums.get(i);
                nums.remove(i);
                i--;
            }
        }
        for(int i=0;i<tmp1.size();i++)
            nums.add(tmp1.get(i));
    }
}

    
    

/*
Given a sorted array and a target value, return the index if the target is found. If not, 
return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.

Example
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(ArrayList<Integer> A, int target) {
        int beg = 0;
        int end = A.size() - 1;
        while(beg <= end){
            int mid = beg + (end - beg)/2;
            if(A.get(mid) < target){
                beg = mid + 1;
            }else if(A.get(mid) > target){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return beg;
    }
}


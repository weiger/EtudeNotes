/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
The array may contain duplicates.
Example
Given [4,4,5,6,7,0,1,2] return 0
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        if(num == null || num.length == 0)
            return -1;
        int beg = 0;
        int end = num.length - 1;
        while(beg < end){
            int mid = beg + (end - beg)/2;
            if(num[beg] < num[end]){
                return num[beg];
            }
            if(num[beg] < num[mid]){
                beg = mid + 1;
            }else if(num[beg] > num[mid]){
                end = mid;
            }else
                beg++;
        }
        return num[beg];
    }
}

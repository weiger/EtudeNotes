/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*/
public class Solution {
    public int findPeakElement(int[] num) {
        if(num==null || num.length==0)
            return -1;
        if(num.length==1)
            return 0;
        int beg = 0;
        int end = num.length - 1;
        while(beg<=end){
            int mid = beg + (end-beg)/2;
            if(mid==0 && mid+1<num.length &&  num[mid]>num[mid+1]){
                return mid;
            }else if(mid==num.length-1 && mid-1>=0 && num[mid]>num[mid-1]){
                return mid;
            }else if(mid+1<num.length && mid>0 && num[mid]>num[mid+1] && num[mid]>num[mid-1]){
                return mid;
            }else if(mid+1<num.length && num[mid]<num[mid+1]){
                beg = mid+1;
            }else if(mid-1>=0 && num[mid]<num[mid-1]){
                end = mid-1;
            }
        }
        return -1;
    }
}

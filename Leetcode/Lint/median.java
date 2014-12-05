/*
Given a unsorted array with integers, find the median of it. 

A median is the middle number of the array after it is sorted. 

If there are even numbers in the array, return the N/2-th number after sorted.

Example
Given [4, 5, 1, 2, 3], return 3

Given [7, 9, 4, 5], return 5
*/
//O(n)
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        Arrays.sort(nums);
        int len = nums.length;
        if(len % 2 == 1){
            return nums[len/2];
        }else{
            return nums[len/2 - 1];
        }
    }
}
//O(n)
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int len = nums.length;
        if(len % 2 == 1){
            return quickselect(nums,len/2);
        }else{
            return quickselect(nums,len/2 - 1);
        }
    }
    public int quickselect(int[] A,int k){
        if(k<0 || k>A.length-1)
            return -1;
        int beg = 0;int end = A.length-1;
        while(beg<end){
            int j = partition(A,beg,end);
            if(j<k) beg = j+1;
            else if(j>k) end = j-1;
            else return A[k];       
        }
        return A[k];
    }
    public int partition(int[] A,int beg,int end){
        if(beg>end)
            return -1;
        int index = beg;
        for(int i=beg;i<end;i++){
            if(A[i]<=A[end])
                swap(A,index++,i);
        }
        swap(A,index,end);
        return index;
    }
    public static void swap(int[] A,int beg,int end){
        int tmp = A[beg];
        A[beg] = A[end];
        A[end] = tmp;
    }
}


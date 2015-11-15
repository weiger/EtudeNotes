public class Solution {
    public int findKthLargest(int[] nums, int k) {
       if(nums == null || nums.length == 0){
           return -1;
       }
       int beg = 0;
       int end = nums.length - 1;
       while(beg < end){
           int j = partition(nums, beg, end);
           if(j < (k - 1)){
               beg = j + 1;
           }else if(j > (k - 1)){
               end = j - 1;
           }else{
               return nums[k - 1];
           }
       }
       return nums[k - 1];
    }
    public int partition(int[] nums, int beg, int end){
        if(beg > end){
            return -1;
        }
        int idx = beg;
        int pivot = nums[end];
        for(int i = beg ; i < end; i++){
            if(nums[i] > pivot){
                swap(nums, idx++, i);
            }
        }
        swap(nums, idx, end);
        return idx;
    }
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

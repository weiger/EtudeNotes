public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        int len = nums.length;
        int k = 0;
        if(len % 2 == 0){
            k = len / 2 - 1;
        }else{
            k = len / 2;
        }
        int beg = 0; int end = nums.length - 1;
        while(beg < end){
            int m = partition(nums, beg, end);
            if(m == k){
                return nums[m];
            }else if(m < k){
                beg = m + 1;
            }else if(m > k){
                end = m - 1;
            }
        }
        return nums[k];
    }

    public int partition(int[] nums, int beg, int end){
        int index = beg;
        for(int i = beg; i < end; i++){
            if(nums[i] < nums[end]){
                swap(nums, i, index++);
            }
        }
        swap(nums, index, end);
        return index;
    }

    public void swap(int[] nums, int beg, int end){
        int tmp = nums[beg];
        nums[beg] = nums[end];
        nums[end] = tmp;
    }
}


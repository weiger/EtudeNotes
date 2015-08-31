public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    int idx = 0;
	    for(int i = 0 ; i < nums.length; i++){
	        if(nums[i] < k){
	            swap(nums, idx++, i);
	        }
	    }
	    return idx;
    }
    
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

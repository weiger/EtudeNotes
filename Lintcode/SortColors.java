class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        int[] color = new int[3];
        for(int val : nums){
            color[val]++;
        }
        int idx = 0;
        for(int i = 0 ; i < color.length; i++){
            while(color[i] > 0){
                nums[idx++] = i;
                color[i]--;
            }
        }
    }
}

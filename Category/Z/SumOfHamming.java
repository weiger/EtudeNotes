public class Solution {
    public int sumOfHamming(int[] nums) {
        int[] numOfOne = new int[32];
        for(int i = 0; i < nums.length; i++){
            int j = 0;
            int one = 1;
            while(nums[i] != 0){
                if((nums[i] & one) != 0){
                    numOfOne[j]++;
                }
                j++;
                nums[i] >>= 1;
            }
        }
        int res = 0;
        for(int i = 0; i < numOfOne.length; i++){
            res += numOfOne[i] * (nums.length - numOfOne[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] data = {1,2,4,8};
        int res = new Solution().sumOfHamming(data);
        System.out.println(res);
    }
}

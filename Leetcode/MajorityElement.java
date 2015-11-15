public class Solution {
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int cnt = 1;
        for(int x: nums){
            if(x == cur){
                cnt++;
            }else{
                cnt--;
                if(cnt == 0){
                    cur = x;
                    cnt = 1;
                }
            }
        }
        return cur;
    }
}

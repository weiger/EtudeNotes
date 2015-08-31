public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int cnt = 1;
        int cur = nums.get(0);
        for(int i = 1; i < nums.size(); i++){
            if(nums.get(i) == cur){
                cnt++;
            }else{
                cnt--;
            }
            if(cnt == 0){
                cur = nums.get(i);
                cnt++;
            }
        }
        return cur;
    }
}

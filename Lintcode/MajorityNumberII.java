public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int cur1 = 0;
        int cur2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0 ; i < nums.size(); i++){
            int num = nums.get(i);
            if(cnt1 > 0 && cur1 == num){
                cnt1++;
            }else if(cur2 > 0 && cur2 == num){
                cnt2++;
            }else if(cnt1 == 0){
                cur1 = num;
                cnt1 = 1;
            }else if(cnt2 == 0){
                cur2 = num;
                cnt2 = 1;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0; i < nums.size(); i++){
            int num = nums.get(i);
            if(num == cur1){
                cnt1++;
            }else if(num == cur2){
                cnt2++;
            }
        }
        return cnt1 > cnt2 ? cur1: cur2;
    }
}

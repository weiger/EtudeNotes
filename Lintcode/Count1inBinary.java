public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        // write your code here
        int cnt = 0;
        for(int i = 0 ; i < 32; i++){
            if((num & (1 << i)) != 0){
                cnt++;
            }
        }
        return cnt;
    }
};

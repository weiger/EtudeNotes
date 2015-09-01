public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        if(str == null || str.length() == 0){
            return 0;
        }
        int i = 0;
        int sign = 1;
        while(str.charAt(i) == ' ') i++;
        if(str.charAt(i) == '-'){
            sign = -1;
            i++;
        }else if(str.charAt(i) == '+'){
            i++;
        }
        long res = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            res = res * 10 + str.charAt(i) - '0';
            if(res > Integer.MAX_VALUE){
                if(sign == -1) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
            i++;
        }
        return (int)(sign * res);
    }
}

public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        if(n < 1) return "";
        String res = "1";
        for(int i = 2; i <= n; i++){
            String cur = "";
            for(int j = 0; j < res.length(); j++){
                int cnt = 1;
                char c = res.charAt(j);
                while(j + cnt < res.length()&& res.charAt(j) == res.charAt(j + cnt)){
                    cnt++;
                }
                cur += cnt + "" + c;
                j += cnt - 1;
            }
            res = cur;
        }
        return res;
    }
}

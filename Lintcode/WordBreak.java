public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here  
        if(s == null || dict == null){
            return false;
        }
        int maxLen = 0;
        for(String str: dict){
            maxLen = Math.max(maxLen, str.length());
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 0; i <= len; i++){
            for(int j = i - 1 ; j >= 0; j--){
                if(i - j > maxLen){
                    break;
                }
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}

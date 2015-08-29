public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        boolean[] dp = getDp(s, wordDict);
        helper(res, wordDict, s, dp, 0, "");
        return res;
    }
    public void helper(List<String> res, Set<String> wordDict, String str, boolean[] dp, int pos, String buffer){
        if(pos == str.length()){
            res.add(buffer.trim());
            return;
        }
        for(int i = pos; i <= str.length(); i++){
            String sub = str.substring(pos, i);
            if(wordDict.contains(sub) && dp[i]){
                helper(res, wordDict, str, dp, i, buffer + sub + " ");
            }
        }
    }
    public boolean[] getDp(String str, Set<String> dict){
        boolean[] dp = new boolean[str.length() + 1];
        dp[str.length()] = true;
        for(int i = str.length() ; i >= 0; i--){
            for(int j = str.length(); j > i; j--){
                if(dict.contains(str.substring(i, j)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp;
    }
}

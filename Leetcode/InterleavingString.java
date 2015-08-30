public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null){
            return false;
        }
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int M = s1.length(); int N = s2.length();
        boolean[][] dp = new boolean[M + 1][N + 1];
        dp[0][0] = true;
        for(int i = 1; i <= M; i++){
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for(int j = 1; j <= N; j++){
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                boolean b1 = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1); 
                boolean b2 = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                if(b1 || b2) dp[i][j] = true;
            }
        }
        return dp[M][N];
    }
}

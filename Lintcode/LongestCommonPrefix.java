public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if(strs == null || strs.length == 0){
            return "";
        }
        String res = strs[0];
        for(int i = 1; i < strs.length; i++){
            if(strs[i].length() == 0){
                return "";
            }
            for(int j = 0; j < Math.min(res.length(), strs[i].length());j++){
                if(res.charAt(j) != strs[i].charAt(j)){
                    res = res.substring(0, j);
                    break;
                }
            }
        }
        return res;
    }
}

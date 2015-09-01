public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        StringBuilder sb = new StringBuilder();
        int k = s.length();
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                k = i;
            }else if(i == 0 || s.charAt(i - 1) == ' '){
                if(sb.length() != 0){
                    sb.append(" ");
                }
                sb.append(s.substring(i, k));
            }
        }
        return sb.toString();
    }
}

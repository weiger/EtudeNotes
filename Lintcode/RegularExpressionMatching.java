public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if(s == null || p == null){
            return false;
        }
        if(p.length() == 0){
            return s.length() == 0;
        }
        if(p.length() == 1){
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }
        if(p.charAt(1) != '*'){
            return s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        }else{
            if(isMatch(s, p.substring(2))){
                return true;
            }
            return s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p);
        }
    }
}

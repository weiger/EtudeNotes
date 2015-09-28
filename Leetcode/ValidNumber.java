/*
 * Validate if a given string is numeric.

 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up 
 * front before implementing one.
 */
 public class Solution {
    public boolean isNumber(String s) {
        if(s.trim().isEmpty()){  
            return false;  
        }  
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";  
        if(s.trim().matches(regex)){  
            return true;  
        }else{  
            return false;  
        }  
    }
}
 
public class Solution {
    public boolean isNumber(String s) {
        int i = 0; int n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean isNum = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            isNum = true;
            i++;
        }
        if (i < n && s.charAt(i) == '.') {
            i++;
            while(i < n && Character.isDigit(s.charAt(i))){
                isNum = true;
                i++;
            }
        }
        if (isNum && i < n && s.charAt(i) == 'e') {
            i++;
            isNum = false;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while(i < n && Character.isDigit(s.charAt(i))){
                isNum = true;
                i++;
            }
        }
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return isNum && i == n;
    }
}

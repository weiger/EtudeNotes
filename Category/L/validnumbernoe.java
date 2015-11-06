public class Solution {
    public boolean isNumber(String str){
        int i = 0;
        str = str.trim();
        int len = str.length();
        if (str.charAt(i) == '+' || str.charAt(i) == '-') i++;
        boolean isValid = false;
        while(i < len && Character.isDigit(str.charAt(i))){
            i++;
            isValid = true;
        }
        if (i < len && str.charAt(i) == '.') {
            i++;
            while (i < len && Character.isDigit(str.charAt(i))) {
                i++;
                isValid = true;
            }
        }
        return isValid && i == len;
    }
}

public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        int i = 0; int len = s.length();
        if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean isValid = false;
        while (i < len && Character.isDigit(s.charAt(i))) {
            isValid = true;
            i++;
        }
        if (i < len && s.charAt(i) == '.') i++;
        while (i < len && Character.isDigit(s.charAt(i))) {
            isValid = true;
            i++;
        }
        if (isValid && i < len && s.charAt(i) == 'e') {
            isValid = false;
            i++;
            if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while (i < len && Character.isDigit(s.charAt(i))) {
                isValid = true;
                i++;
            }
        }
        return isValid && i == len;
    }
}

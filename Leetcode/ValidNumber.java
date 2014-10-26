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
 
public class ValidNumber {
    public boolean isNumber(String s) {
        s = s.trim();
        if(s.equals(""))
           return false; 
        boolean hasDot = false, hasE = false, hasNum = false;
        for(int k = 0; k < s.length(); k++) {
            if(s.charAt(k) == '-' || s.charAt(k) == '+') {
            	if(k == s.length() - 1 || k > 0 && s.charAt(k - 1) != 'e')
            		return false;
            }
            else if(s.charAt(k) == 'e') {
                if(hasE || k == s.length() - 1 || !hasNum || k == 0 || k == s.length() - 1)
                    return false;
                hasE = true;
            }
            else if(s.charAt(k) == '.') {
                if(hasE || hasDot || k == s.length() - 1 && !hasNum
                        || k < s.length() - 1 && (s.charAt(k + 1) == '+' || s.charAt(k + 1) == '-'))
                    return false;
                hasDot = true;
            }
            else if(s.charAt(k) - '0' >= 0 && s.charAt(k) - '0' <= 9)
                hasNum = true;
            else
                return false;
        }
        return true;
    }       
}

public class ValidNumber {
 
    // 556ms for 1479 test cases
    public boolean isNumber(String s) {
        s = s.trim();       // Get rid of leading and trailing whitespaces
        int n = s.length();
        if (n == 0)
            return false;
        boolean isFractional = false;   // Indicate appearance of '.'
        boolean isExponential = false;  // Indicate appearance of 'e/E'
        boolean valid = false;          // Indicate whether preceding digits are valid
        boolean expoBefore = false;     // Indicate whether the preceding digit is 'e/E'
        boolean validFrac = true;       // Indicate whether the number is a vaild fraction (true by default)
        boolean validExpo = true;       // Indicate whether the number is a valid exponential (true by default)
        int i = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-')   // Consider sign
            i = 1;
        // Process each digit in sequence
        for (; i < n; i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {     // +/- is valid only after e/E
                if (!expoBefore)
                    return false;
                expoBefore = false;
                valid = false;
            } else if (c == 'e' || c == 'E') {  // Only one e/E is valid; preceding digits should be valid
                if (isExponential || !valid)
                    return false;
                isExponential = true;
                valid = false;
                expoBefore = true;
                validExpo = false;
            } else if (c == '.') {  // Only one '.' is valid; cannot appear as an exponential
                if (isFractional || isExponential)
                    return false;
                isFractional = true;
                if (!valid)     // Must have fractional part
                    validFrac = false;
            } else if (c >= '0' && c <='9') {   // Regular digits
                valid = true;
                expoBefore = false;
                validFrac = true;
                validExpo = true;
            } else {
                return false;
            }
        }
        // After reaching the end, make sure the number is indeed valid
        if (!valid || !validFrac || !validExpo)
            return false;
        else
            return true;
    }
}

// Only contains '(' ')'
public class Solution {
    public boolean isValidParenthesis(String str) {
        if (str == null || str.length() == 1) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            } else if (str.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}

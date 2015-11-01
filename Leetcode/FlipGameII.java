public class Solution {
    public boolean canWin(String s) {
        for (int i = 0 ; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                if (!canWin(s.substring(0, i) + "--" + s.substring(i + 2))) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class Solution {
    public boolean canWin(String s) {
        for (int i = -1 ; (i = s.indexOf("++", i + 1)) >= 0; ) {
            if (!canWin(s.substring(0, i) + "--" + s.substring(i + 2))) {
                return true;
            }
        }
        return false;
    }
}

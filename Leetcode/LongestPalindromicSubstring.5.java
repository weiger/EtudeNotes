//O(n^2)
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        String res = "";
        for (int i = 1; i < s.length(); i++) {
            String strA = helper(s, i, i);
            String strB = helper(s, i - 1, i);
            if (strA.length() > res.length()) {
                res = strA;
            }
            if (strB.length() > res.length()) {
                res = strB;
            }
        }
        return res;
    }

    public String helper(String str, int beg, int end) {
        while (beg >= 0 && end < str.length() && str.charAt(beg) == str.charAt(end)) {
            beg--;
            end++;
        }
        return str.substring(beg + 1, end);
    }
}

//Manacher O(n)
public class Solution {
    public String longestPalindrome(String s) {
        StringBuilder newStr = new StringBuilder();
        newStr.append('#');
        for (int i = 0; i < s.length(); i++) {
            newStr.append(s.charAt(i));
            newStr.append('#');
        }

        int[] rad = new int[newStr.length()];
        int right = -1;
        int id = -1;

        for (int i = 0; i < newStr.length(); i++) {
            int r = 1;
            if (i <= right) {
                r = Math.min(rad[id] - i + id, rad[2 * id - i]);
            }
            while (i - r >= 0 && i + r < newStr.length()
                    && newStr.charAt(i - r) == newStr.charAt(i + r)) {
                r++;
            }

            if (i + r - 1 > right) {
                right = i + r - 1;
                id = i;
            }
            rad[i] = r;
        }

        int maxLength = 1;
        int mid = 0;
        for (int i = 0; i < rad.length; i++) {
            if (rad[i] > maxLength) {
                maxLength = rad[i];
                mid = i;
            }
        }
        return s.substring((mid - maxLength + 1) / 2, (mid + maxLength - 1) / 2);
    }
}

/*
 * Given a string S, find the longest palindromic substring in S. You may assume that the 
 * maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
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

    int maxLength = 1;int mid = 0;
    for(int i=0;i<rad.length;i++){
        if(rad[i]>maxLength){
            maxLength = rad[i];
            mid = i;
        }
    }

    return s.substring((mid-maxLength+1 )/2 , (mid + maxLength -1) /2);
    }
}
 
 
public class LongestPalindromicSubstring {

    // O(n^2) time and no space cost 
    public String expandAroundcenterenter(String s, int i, int j) {
        int left = i, right = j;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public String longestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        String longest = "";
        for(int i = 0; i < s.length(); i++) {
            String expand = expandAroundcenterenter(s, i, i);
            if(longest.length() < expand.length())
                longest = expand;
            expand = expandAroundcenterenter(s, i, i + 1);
            if(longest.length() < expand.length())
                longest = expand;
        }
        return longest;
    }


    //hard to understand and waste of time
    /** O(n) time and O(n) space cost. */
    public String preProcess(String s) {
        if(s.length() == 0)
            return "#";
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            result += "#" + s.charAt(i);
        }
        result += "#";
        return result;
    }

    public String longestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int center = 0, rightMost = 0;
        for(int i = 1; i < n - 1; i++) {
            int i_mirror = 2 * center - i;
            P[i] = rightMost > i ? Math.min(rightMost - i, P[i_mirror]) : 0; 
            while(i + 1 + P[i] < n && i >= 1 + P[i] && T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }
            if(P[i] > center) {
                center = i;
                rightMost = i + center;
            }
        }
        int maxLen = 0, beginAt = 0;
        for(int i = 1; i < n - 1; i++) {
            if(maxLen < P[i]) {
                maxLen = P[i];
                beginAt = i;
            }
        }
        return s.substring((beginAt - maxLen) / 2, (beginAt - maxLen)/ 2 + maxLen);
    }
}

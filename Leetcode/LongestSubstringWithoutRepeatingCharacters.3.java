public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int beg = 0; int end = 0; int res = 0;
        while (beg < len && end <len) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                res = Math.max(res, end - beg);
            } else {
                set.remove(s.charAt(beg++));
            }
        }
        return res;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return res;
    }
}
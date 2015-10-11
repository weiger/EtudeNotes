public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        return isMatch(pattern, 0, str, 0, new HashMap<Character, String>(), new HashSet<String>());
    }

    public boolean isMatch(String pattern, int p, String str, int s, HashMap<Character, String> map, HashSet<String> set) {
        if (p == pattern.length()) {
            return s == str.length();
        }
        char c = pattern.charAt(p);
        if (map.containsKey(c)) {
            String cur = map.get(c);
            int len = map.get(c).length();
            if (s + len > str.length() || !str.substring(s, s + len).equals(cur)) {
                return false;
            } else {
                return isMatch(pattern, p + 1, str, s + len, map, set);
            }
        } else {
            for (int len = 1; s + len <= str.length(); len++) {
                if (set.contains(str.substring(s, s + len))) continue;
                map.put(c, str.substring(s, s + len));
                set.add(str.substring(s, s + len));
                if (isMatch(pattern, p + 1, str, s + len, map, set)) {
                    return true;
                }
                set.remove(str.substring(s, s + len));
                map.remove(c);
            }
        }
        return false;
    }
}

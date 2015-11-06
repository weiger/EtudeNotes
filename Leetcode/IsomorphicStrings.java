public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> m1 = new HashMap<>();
        HashMap<Character, Character> m2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (!m1.containsKey(a) && !m2.containsKey(b)) {
                m1.put(a, b);
                m2.put(b, a);
            } else {
                if (m1.get(a) == null || m2.get(b) == null || b != m1.get(a) || a != m2.get(b)) {
                    return false;
                }
            }
        }
        return true;
    }
}

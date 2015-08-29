public class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1) {
            return map.get(s.charAt(0));
        }
    
        int i = 0;
        int res = 0;
        while (i < s.length()) {
            int current = map.get(s.charAt(i));
            int forward = 0;
            if (i + 1 < s.length()) {
                forward = map.get(s.charAt(i + 1));
            }
            if (current >= forward) {
                res += current;
                i++;
            } else {
                res += forward - current;
                i += 2;
            }
        }
        return res;
    }
}

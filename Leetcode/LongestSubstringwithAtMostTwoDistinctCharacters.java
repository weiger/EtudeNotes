public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        return helper(s, 2);
    }
    
    public int helper(String s, int k){
        if (s == null || k <= 0 ){
            return 0;
        }
        if (s.length() < k ) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        int j = 0;
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            while (map.size() > k) {
                char d = s.charAt(j);
                if (map.containsKey(d)) {
                    if (map.get(d) == 1) {
                        map.remove(d);
                    } else {
                        map.put(d, map.get(d) - 1);
                    }
                }
                j++;
            }
            len = Math.max(len, i - j + 1);
        }
        return len;
    }
}

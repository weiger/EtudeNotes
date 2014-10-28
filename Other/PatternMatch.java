/*
find if   string follows the same pattern and return 0 or 1. 
Examples: 1) Pattern : "abba", input: "redblueredblue" should return 1. 
2) Pattern: "aaaa", input: "asdasdasdasd" should return 1. 
3) Pattern: "aabb", input: "xyzabcxzyabc" should return 0. 
*/
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        String pattern = "abab";
        String input = "redblueredblue";
        Map<Character, String> map = new HashMap<Character, String>();
        System.out.println(isMatch(pattern, 0, input, 0, map));
    }

    public static boolean isMatch(String p, int pidx, String input, int start,
        Map<Character, String> map) {
        if (start == input.length() && pidx == p.length())
            return true;
        char c = p.charAt(pidx);
        if (map.get(c) != null) {
            int len = map.get(c).length();
            if (start + len > input.length()
                || !input.substring(start, start + len).equals(map.get(c))) {
                return false;
        } else
        return isMatch(p, pidx + 1, input, start + len, map);
    } else {
        for (int len = 1; len <= input.length() - start; len++) {
            map.put(c, input.substring(start, start + len));
            if (isMatch(p, pidx + 1, input, start + len, map))
                return true;
            map.remove(c);
        }
    }
    return false;
  }
}

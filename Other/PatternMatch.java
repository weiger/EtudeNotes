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
    	map.clear();
    	System.out.println(isMatch("aaaa", 0, "asdasdasdasd", 0, map));
    	map.clear();
    	System.out.println(isMatch("aabb", 0, "xyzabcxzyabc", 0, map));
    }

    public static boolean isMatch(String pattern, int p, String str, int s,
	    Map<Character, String> map) {
	if (p == pattern.length() && s == str.length())
	    return true;
	char c = pattern.charAt(p);
	if (map.containsKey(c)) {
	    int len = map.get(c).length();

	    if (s + len > str.length()
		    || !str.substring(s, s + len).equals(map.get(c))) {
		    return false;
	    } else {
		    return isMatch(pattern, p + 1, str, s + len, map);
	    }
	} else {
	    for (int len = 1; len <= str.length() - s; len++) {
    		map.put(c, str.substring(s, s + len));
    		if (isMatch(pattern, p + 1, str, p + len, map))
    		    return true;
    		map.remove(c);
	    }
	}
	    return false;
    }

}



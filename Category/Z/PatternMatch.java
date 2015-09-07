public class Solution {

    public static void main(String[] args) {
        Map<Character, String> map = new HashMap<Character, String>();
        System.out.println(true == isMatch("abab", 0, "redblueredblue", 0, new HashMap<Character, String>()));
        map.clear();
        System.out.println(true == isMatch("aaaa", 0, "asdasdasdasd", 0, new HashMap<Character, String>()));
        map.clear();
        System.out.println(false == isMatch("aabb", 0, "xyzabcxzyabc", 0, new HashMap<Character, String>()));
        map.clear();
        System.out.println(true == isMatch("abcba", 0, "microsoftfacebookgooglefacebookmicrosoft", 0, new HashMap<Character, String>()));
    }

    public static boolean isMatch(String pattern, int p, String str, int s,
                                  Map<Character, String> map) {
        if(p == pattern.length()){
            return s == str.length();
        }
        char c = pattern.charAt(p);
        if(map.containsKey(c)){
            int len = map.get(c).length();
            if(s + len > str.length() - 1 || !str.substring(s, s + len).equals(map.get(c))){
                return false;
            }else{
                return isMatch(pattern, p + 1, str, s + len, map);
            }
        }else{
            for(int len = 1; len <= str.length() - s; len++){
                map.put(c, str.substring(s, s + len));
                if(isMatch(pattern, p + 1, str, s + len, map)){
                    return true;
                }
                map.remove(c);
            }
        }
        return false;
    }
}

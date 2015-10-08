public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        char[] arr = pattern.toCharArray();
        if(strs.length != arr.length){
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0 ; i < arr.length; i++) {
            char c = arr[i];
            if (!map.containsKey(c)) {
                if (map.containsValue(strs[i])) {
                    return false;
                }
                map.put(c, strs[i]);
            } else {
                if (!map.get(c).equals(strs[i])){
                    return false;
                }
            }
        }
        return true;
    }
}

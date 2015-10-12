/*
 * Given an array of strings, return all groups of strings that are anagrams.

 * Note: All inputs will be in lower-case.
 * For example:

 * Input:¡¡¡¡["tea","and","ate","eat","den"]

 * Output:   ["tea","ate","eat"]
 * 
 */
public class Solution {
    
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String newstr = new String(arr);
            if (!map.containsKey(newstr)) {
                map.put(newstr, i);
            } else {
                if (map.get(newstr) >= 0) {
                    res.add(strs[map.get(newstr)]);
                    map.put(newstr, -1);
                }
                res.add(strs[i]);
            }
        }
        return res;
    }
}

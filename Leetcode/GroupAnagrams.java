public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String newstr = new String(arr);
            if (!map.containsKey(newstr)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(newstr, list);
                res.add(list);
            } else {
                map.get(newstr).add(strs[i]);
            }
        }
        for (List<String> e: res) {
            Collections.sort(e);
        }
        return res;
    }
}

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return res;
        }
        for(int i = 0 ; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String newstr = new String(arr);
            if (map.containsKey(newstr)) {
                if (map.get(newstr) != -1) {
                    res.add(strs[map.get(newstr)]);
                    map.put(newstr, -1);
                }
                res.add(strs[i]);
            } else {
                map.put(newstr, i);
            }
        }
        return res;
    }
}

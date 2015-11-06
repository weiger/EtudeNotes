public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String substr = s.substring(i, i + 10);
            if (map.containsKey(substr)) {
                map.put(substr, map.get(substr) + 1);
            } else {
                map.put(substr, 1);
            }
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() >= 2) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String substr = s.substring(i, i + 10);
            int num = toHash(substr);
            if (map.containsKey(num)) {
                if (!map.get(num)) {
                    res.add(substr);
                    map.put(num, true);
                }
            } else {
                map.put(num, false);
            }
        }
        return res;
    }
    
    public int toHash(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'A') sb.append('0');
            if (c == 'C') sb.append('1');
            if (c == 'G') sb.append('2');
            if (c == 'T') sb.append('3');
        }
        return Integer.parseInt(sb.toString(), 4);
    }
}

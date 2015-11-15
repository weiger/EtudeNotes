public class Solution {
    public int similarity(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        HashMap<String, Integer> m1 = new HashMap<>();
        HashMap<String, Integer> m2 = new HashMap<>();
        String[] strs1 = s1.split(" ");
        String[] strs2 = s2.split(" ");
        for (String s: strs1) {
            if (!m1.containsKey(s)) {
                m1.put(s, 1);
            } else {
                m1.put(s, m1.get(s) + 1);
            }
        }
        for (String s: strs2) {
            if (!m2.containsKey(s)) {
                m2.put(s, 1);
            } else {
                m2.put(s, m2.get(s) + 1);
            }
        }
        int res = 0;
        for (String e: m1.keySet()) {
            if (m2.containsKey(e)) {
                res += m1.get(e) * m2.get(e);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String doc1 = "bar doc doc doc1 foo foo";
        String doc2 = "bar bat doc doc doc2 foo";
        Solution s = new Solution();
        System.out.println(s.similarity(doc1, doc2));
    }
}

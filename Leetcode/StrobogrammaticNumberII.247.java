public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    public List<String> helper(int m, int n){
        if (m == 0) {
            return Arrays.asList("");
        }
        if (m == 1) {
            return Arrays.asList("0", "1", "8");
        }
        List<String> res = new ArrayList<>();
        List<String> sub = helper(m - 2, n);
        for (String str: sub) {
            if (m != n) {
                res.add("0" + str + "0");
            }
            res.add("1" + str + "1");
            res.add("8" + str + "8");
            res.add("6" + str + "9");
            res.add("9" + str + "6");
        }
        return res;
    }
}
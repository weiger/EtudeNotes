public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 0 ; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i) == s.charAt(i + 1)) {
                String newstr = s.substring(0, i) + "--" + s.substring(i + 2);
                res.add(newstr);
            }
        }
        return res;
    }
}

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        for (int i = - 1; (i = s.indexOf("++", i + 1)) >= 0; ) {
            res.add(s.substring(0, i) + "--" + s.substring(i + 2));
        }
        return res;
    }
}

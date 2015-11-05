public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        helper(res, s, "", 0, 0, 0);
        return res;
    }
    public void helper(List<String> res, String org, String buffer, int pos, int left, int right){
        if (left < right) return;
        if (pos == org.length()) {
            if (left == right) {
                if (res.size() == 0) {
                    res.add(buffer);
                } else if (buffer.length() > res.get(0).length()) {
                    res.clear();
                    res.add(buffer);
                } else if (buffer.length() == res.get(0).length() && !res.contains(buffer)) {
                    res.add(buffer);
                }
                return;
            } else {
                return;
            }
        }
        if (org.charAt(pos) == '(') {
            helper(res, org, buffer + "(", pos + 1, left + 1, right);
            helper(res, org, buffer, pos + 1, left, right);
        } else if (org.charAt(pos) == ')') {
            helper(res, org, buffer + ")", pos + 1, left, right + 1);
            helper(res, org, buffer, pos + 1, left, right);
        } else {
            helper(res, org, buffer + org.charAt(pos), pos + 1, left, right);
        }
    }
}

public class Solution {
    public int findLongestRepeating(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int res = 1;
        int cur = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Solution test = new Solution();
        int num = test.findLongestRepeating("aabbbbccc");
        System.out.println(num);
    }
}

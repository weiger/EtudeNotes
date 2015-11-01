public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        int factor = 1;
        for (int i = 1; i <= n; i++) {
            factor *= i;
            str += i;
        }
        k--;
        while (n > 0) {
            factor /= n;
            sb.append(str.charAt(k / factor));
            str = str.substring(0, k / factor) + str.substring(k / factor + 1);
            k %= factor;
            n--;
        }
        return sb.toString();
    }
}

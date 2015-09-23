public class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            n--;
            res.append(char(n % 26 + 'A'));
            n /= 26;
        }
        return res.reverse().toString();
    }
}

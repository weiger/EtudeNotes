public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        n++;
        while (n > 0) {
            n--;
            sb.append((char)('A' + n % 3));
            n /= 3;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " : " + s.convertToTitle(i));
        }
    }
}

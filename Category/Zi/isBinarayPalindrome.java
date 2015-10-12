public class Solution {
    public boolean isBinarayPalindrome(int n){
        int bits = 0;
        int tmp = n;
        while (tmp != 0) {
            bits++;
            tmp = tmp >> 1;
        }
        bits = bits - 1;
        while (n > 0) {
            int left = ((n >> bits) & 1);
            int right = (n & 1);
            if (left != right) {
                return false;
            }
            n = (n ^ (1 << bits));
            n = (n >> 1);
            bits = bits - 2;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(17));
        System.out.println(Integer.toBinaryString(26));
        System.out.println(Integer.toBinaryString(29));
        System.out.println(Integer.toBinaryString(31));
        Solution test = new Solution();
        System.out.println(test.isBinarayPalindrome(32));
    }
}

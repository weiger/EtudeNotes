public class Solution {

    public static boolean checkInteger(String str) {
        str = str.trim();
        long res = 0;
        int i = 0;
        int sign = 1;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') {
                sign = -1;
                i++;
            }
        }

        while (i < str.length()) {
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) {
                System.out.println(res);
                return false;
            } else if (sign == -1 && sign * res < Integer.MIN_VALUE) {
                System.out.println(res);
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(checkInteger("-2147483649"));
    }
}

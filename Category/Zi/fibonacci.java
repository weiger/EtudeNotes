public class Solution {

    public int fibonacci1(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public int fibonacci2(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fibonacci2(n - 1) + fibonacci2(n - 2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fibonacci1(5));
        System.out.println(s.fibonacci2(5));
    }

}

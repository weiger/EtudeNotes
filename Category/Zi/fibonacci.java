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
    
    public static int fibonacciListSum(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += result[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fibonacci1(5));
        System.out.println(s.fibonacci2(5));
    }

}

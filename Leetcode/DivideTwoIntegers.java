public class Solution {
    public int divide(int dividend, int divisor) {
        long res = helper(dividend, divisor);
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
    }

    public long helper(long dividend, long divisor) {
        boolean neg = dividend < 0 != divisor < 0;
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;
        if (dividend < divisor) return 0;
        long sum = divisor;
        long divide = 1;
        while ((sum + sum) <= dividend) {
            sum += sum;
            divide += divide;
        }
        if (neg) {
            return -(divide + helper((dividend - sum), divisor));
        } else {
            return divide + helper((dividend - sum), divisor);
        }
    }
}

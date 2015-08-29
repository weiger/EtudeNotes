/*
 * Given a number represented as an array of digits, plus one to the number.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int tmp = digits[i];
            digits[i] = (digits[i] + carry) % 10;
            carry = (tmp + carry) / 10;
        }
        if(carry == 1){
            int[] res = new int[digits.length + 1];
            Arrays.fill(res, 0);
            res[0] = 1;
            return res;
        }
        return digits;
    }
}

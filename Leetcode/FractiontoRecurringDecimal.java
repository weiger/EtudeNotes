public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        if(denominator == 0)
            return "";
        String res = "";
        if((numerator < 0) ^ (denominator < 0))
            res += "-";
        long num = (long)numerator;
        long den = (long)denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        res += String.valueOf(num / den);
        long rem = (num % den) * 10;
        if(rem == 0) return res;
        res += ".";
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while(rem != 0){
            if(map.containsKey(rem)){
                String str1 = res.substring(0, map.get(rem));
                String str2 = res.substring(map.get(rem));
                res = str1 + "(" + str2 + ")";
                return res;
            }
            map.put(rem, res.length());
            res += String.valueOf(rem / den);
            rem = (rem % den) * 10;
        }
        return res;
    }
}

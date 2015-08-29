public class Solution {
    public String intToRoman(int num) {
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] huns = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thos = {"", "M", "MM", "MMM", "", "", "", "", "", ""};

        String result = "";
        result += thos[num / 1000];
        result += huns[num % 1000 / 100];
        result += tens[num % 100 / 10];
        result += ones[num % 10];
        return result;
    }
}

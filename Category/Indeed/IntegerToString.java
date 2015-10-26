/*
0 -> A
1 -> B
2 -> C
3 -> AA
4 -> AB
5 -> AC
6 -> BA
7 -> BB
8 -> BC
9 -> CA
10 -> CB
11 -> CC
12 -> AAA
13 -> AAB
*/
public class Solution {
    public String integerToString(int num) {
        if (num < 0) {
            return "";
        }
        num++;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            num--;
            sb.append((char) ('A' + num % 3));
            num /= 3;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i <= 13; i++) {
            System.out.println(i + " : " + s.integerToString(i));
        }
    }
}

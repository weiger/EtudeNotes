// 分数相加，获得最简分数，example： 输入“2 / 3 + 5 / 6 + 3 / 4 ”， 输出“9 / 4"
public class Solution {
    public String addString(String str) {
        if (str == null || str.length() == 0) return str;
        String[] strs = str.split(" \\+ ");
        String res = strs[0].trim();
        for (int i = 1; i < strs.length; i++) {
            String tmp = simplify(add(res, strs[i]));
            res = tmp;
        }
        return res;
    }

    public String add(String a, String b) {
        String[] strs = a.split(" ");
        int adda1 = Integer.parseInt(strs[0]);
        int adda2 = Integer.parseInt(strs[strs.length - 1]);
        strs = b.split(" ");
        int addb1 = Integer.parseInt(strs[0]);
        int addb2 = Integer.parseInt(strs[strs.length - 1]);
        StringBuilder sb = new StringBuilder();
        sb.append(adda1 * addb2 + adda2 * addb1);
        sb.append(" / ");
        sb.append(adda2 * addb2);
        return sb.toString();
    }


    public String simplify(String str) {
        String[] strs = str.split(" ");
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[strs.length - 1]);
        int gcd = GCD(a, b);
        StringBuilder sb = new StringBuilder();
        sb.append(a / gcd);
        sb.append(" / ");
        sb.append(b / gcd);
        return sb.toString();
    }

    public int GCD(int a, int b) {

        while (b != 0) {
            int c = a;
            a = b;
            b = c % b;
        }
        return a;
    }
    
    public static void main(String[] args) {
        String res = new Solution().addString("2 / 3 + 5 / 6 + 3 / 4");
        System.out.println(res);
    }
}

/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...

 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.

 * Given an integer n, generate the nth sequence.

 * Note: The sequence of integers will be represented as a string.
 */
public class Solution {
    public String countAndSay(int n) {
        if(n<=0)
            return null;
        String res = "1";
        int num = 1;
        for(int j=1;j<n;j++){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<res.length();i++){
                if(i<res.length()-1 && res.charAt(i)==res.charAt(i+1)){
                    num++;
                }else{
                    sb.append(num+""+res.charAt(i));
                    num = 1;
                }
            }
            res = sb.toString();
        }
        return res;
    }
}



public class CountAndSay {
/***************************** updated 2014.01.10 ****************************/

    public String countAndSay(int n) {
        String res = "1";
        for(int i = 2; i <= n; i++) {
            int len = res.length();
            int cnt = 1;
            String temp = "";
            for(int j = 1; j < len; j++) {
                if(res.charAt(j) != res.charAt(j - 1)) {
                    temp += "" + cnt + res.charAt(j - 1);
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
            temp += "" + cnt + res.charAt(len - 1);
            res = temp;
        }
        return res;
    }

/*****************************************************************************/

    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String s = countAndSay(n - 1);
        int cnt = 1;
        String res = "";
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i - 1)) {
                res += "" + cnt + s.charAt(i - 1);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        res += "" + cnt + s.charAt(s.length() - 1);
        return res;
    }
}

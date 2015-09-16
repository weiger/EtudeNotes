import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
/*
[if(if(if())), if(if()if()), if(if())if(), if()if(if()), if()if()if()]
*/
public class Solution {
    public List<String> generate(int n) {
        List<String> res = new ArrayList<>();
        helper(res, n, n, "");
        return res;
    }

    public void helper(List<String> list, int L, int R, String str){
        if(L == 0 && R == 0){
            list.add(str);
            return;
        }
        if(L > 0){
            helper(list, L - 1, R, str + "if(");
        }
        if(R > L){
            helper(list, L, R - 1, str + ")");
        }
    }

    public static void main(String[] args) {
        List<String> res = new Solution().generate(3);
        System.out.println(res);
    }
}
/*
变种 n = 2 打印
(
    (
    )
)
, 
(
)
(
)
*/
public class Solution {
    public List<String> generate(int n) {
        List<String> res = new ArrayList<>();
        helper(res, n, n, "\n", n);
        return res;
    }

    public void helper(List<String> list, int L, int R, String str, int n) {
        if (L == 0 && R == 0) {
            list.add(str);
            return;
        }
        if (L > 0) {
            int val = Math.abs(L - R);
            String tab = "";
            for (int i = 0 ; i < val; i++){
                tab += "    ";
            }

            helper(list, L - 1, R,  str +  tab + "(\n", n);


        }
        if (R > L) {
            int val = Math.abs(L - R + 1);
            String tab = "";
            for (int i = 0 ; i < val; i++){
                tab += "    ";
            }

            helper(list, L, R - 1, str +  tab +  ")\n", n);
        }
    }

    public static void main(String[] args) {
        List<String> res = new Solution().generate(3);
        System.out.println(res);
    }
}

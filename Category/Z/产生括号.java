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
        helper(res, "\n", n, n);
        return res;
    }

    public void helper(List<String> res, String str, int left, int right){
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left > 0) {
            int val = Math.abs(left - right);
            String tab = "";
            for (int i = 0 ; i < val; i++){
                tab += "    ";
            }
            helper(res, str + tab + "{\n", left - 1, right);
        }

        if (left < right) {
            int val = Math.abs(left - right);
            String tab = "";
            for (int i = 0 ; i < val - 1; i++){
                tab += "    ";
            }
            helper(res, str + tab + "}\n", left, right - 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = new Solution().generate(3);
        System.out.println(res);
    }
}

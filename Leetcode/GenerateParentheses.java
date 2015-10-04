/*
 * Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.

 * For example, given n = 3, a solution set is:

 * "((()))", "(()())", "(())()", "()(())", "()()()" 
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res,n,n,"");
        return res;
    }
    public void helper(List<String> res,int left,int right,String str){
        if(left==0 && right==0){
            res.add(str);
            return; 
        }
        if(left>0)
            helper(res,left-1,right,str+"(");
        if(left<right)
            helper(res,left,right-1,str+")");
    }
} 
 
public class Solution {
    public static List<String> generateParenthesis(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> one = new ArrayList<>();
        one.add("");
        res.add(one);

        for (int i = 1; i <= n; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> left = res.get(j);
                List<String> right = res.get(i - j - 1);
                for (int k = 0; k < left.size(); k++) {
                    for (int l = 0; l < right.size(); l++) {
                        list.add("(" + left.get(k) + ")" + right.get(l));
                    }
                }
            }
            res.add(list);
        }
        return res.get(n);
    }
}


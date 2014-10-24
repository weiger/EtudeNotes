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
 
 
public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if(n == 0) 
            res.add("");
        else if(n == 1) 
            res.add("()");
        else {
            for(int i = 0; i < n; i++) 
                for(String inner : generateParenthesis(i)) 
                    for(String outer : generateParenthesis(n - 1 - i))
                        res.add("(" + inner + ")" + outer);
        }
        return res;
    }
}

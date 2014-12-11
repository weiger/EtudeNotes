/*
Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
Example
given s = "aab",
Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]
*/
public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s==null)
            return res;
        List<String> list = new ArrayList<>();
        helper(res,list,s);
        return res;
    }
    public void helper(List<List<String>> res,List<String> list,String s){
        if(s.length()==0){
            res.add(new ArrayList<>(list));
        }
        for(int i=0;i<=s.length();i++){
            String tmp = s.substring(0,i);
            if(isP(tmp) && !tmp.equals("")){
                list.add(tmp);
                helper(res,list,s.substring(i));
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isP(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }
}

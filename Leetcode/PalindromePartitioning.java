/*
Given a string s, partition s such that every substring of the partition is 
a palindrome.
Return all possible palindrome partitioning of s.
For example, given s = "aab",
Return
  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        dfs(res, list, s);
        return res;
    }
    public void dfs(List<List<String>> res, List<String> list, String s){
        if(s.length() == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 1 ; i <= s.length(); i++){
            String sub = s.substring(0, i);
            if(isPalindrome(sub)){
                list.add(sub);
                dfs(res, list, s.substring(i));
                list.remove(list.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String str){
        int beg = 0; int end = str.length() - 1;
        while(beg < end){
            if(str.charAt(beg) != str.charAt(end)){
                return false;
            }
            beg++; end--;
        }
        return true;
    }
}

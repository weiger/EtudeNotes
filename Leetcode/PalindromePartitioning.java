/*
 * Given a string s, partition s such that every substring of the partition is 
 * a palindrome.

 * Return all possible palindrome partitioning of s.

 * For example, given s = "aab",
 * Return

 *  [
 *    ["aa","b"],
 *    ["a","a","b"]
 *  ]
 */

import java.util.*;

public class PalindromePartitioning {
    
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        if (s.length() == 1) {
            list.add(s);
            res.add(list);
            return res;
        }
        if (isPalindrome(s)) {
            list.add(s);
            res.add(list);
        }
        for (int i = 1; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i))) {
                ArrayList<ArrayList<String>> temp = partition(s.substring(i));
                for (ArrayList<String> subList : temp) {
                    subList.add(0, s.substring(0, i));
                    res.add(subList);
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) 
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        return true;
    }

}
/************************************************/
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s)
	{
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		dfs(res,list,s);
		return res;
	}
	public void dfs(ArrayList<ArrayList<String>> res,ArrayList<String> list,String s){
	    if(s.length()==0){
	        res.add(new ArrayList<String>(list));
	    }
	    for(int i=1;i<=s.length();i++){
	        if(isPalindrome(s.substring(0,i))){
	            list.add(s.substring(0,i));
	            String rest = s.substring(i);
	            dfs(res,list,rest);
	            list.remove(list.size()-1);
	        }
	    }
	}
	public static boolean isPalindrome(String s){
		if(s.length()==0) return false;
		if(s.length()==1) return true;
		if(s.length()==2 && s.charAt(0)==s.charAt(s.length()-1)) return true;
		if(s.charAt(0)!=s.charAt(s.length()-1)) return false;
		else
			return isPalindrome(s.substring(1, s.length()-1));
	}
}

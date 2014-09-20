/*Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"]. */

//DP+DFS
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {  
        ArrayList<String> res = new ArrayList<String>();
    	String temp = "";
    	boolean[] possible = new boolean[s.length() + 1];
    	possible[s.length()] = true;
    	for (int i = s.length() - 1; i >= 0; i--) {
    	    for (int j = s.length(); j > i; j--) {
    		possible[i] = possible[j] && dict.contains(s.substring(i, j));
    		if (possible[i])
    		    break;
    	    }
	}
	helper(s, dict, res, temp, 0, possible);
	return res; 
    }  
     public void helper(String s, Set<String> dict, ArrayList<String> res,
	    String temp, int index, boolean[] possible) {
    	if (index >= s.length()) {
    	    res.add(temp.trim());
    	    return;
    	}
    	String t;
    	for (int i = index; i < s.length(); i++) {
    	    if (dict.contains(s.substring(index, i + 1)) && possible[i + 1]) {
    		t = temp + s.substring(index, i + 1) + " ";
    		helper(s, dict, res, t, i + 1, possible);
    		t = temp;
    	    }
    	}
    }
}
//
public class Solution {
   public ArrayList<String> wordBreak(String s, Set<String> dict) {
    	ArrayList<String> res = new ArrayList<String>();
    	boolean[] possible = new boolean[s.length() + 1];
    	possible[s.length()] = true;
    	for (int i = s.length() - 1; i >= 0; i--) {    //dp[i] meas substring(i,end) can be break
    	    for (int j = s.length(); j > i; j--) {
    		possible[i] = possible[j] && dict.contains(s.substring(i, j));
    		if (possible[i])
    		    break;
    	    }
    	}
    	helper(s, dict, 0, "", res, possible);
    	return res;
    }
    
    private void helper(String s, Set<String> dict, int start, String item,
	    ArrayList<String> res,boolean[] possible) {
    	if (start >= s.length()) { //be careful of level.equals is enough
    	    res.add(item);
    	    return;
    	}
    	StringBuilder str = new StringBuilder();
    	for (int i = start; i < s.length(); i++) {
    	    str.append(s.charAt(i));
    	    if (possible[i+1]&&dict.contains(str.toString())) {   // be careful i+1
    		String newItem = item.length() > 0 ? (item + " " + str
    			.toString()) : str.toString();
    		helper(s, dict, i + 1, newItem, res,possible);
    	    }
    	    //it can be String temp = item; item = temp;
    	}
    }
}

//Brutal Force TLE
public ArrayList<String> wordBreak(String s, Set<String> dict) {  
    ArrayList<String> res = new ArrayList<String>();  
    if(s==null || s.length()==0)  
        return res;  
    helper(s,dict,0,"",res);  
    return res;  
}  
private void helper(String s, Set<String> dict, int start, String item, ArrayList<String> res)  
{  
    if(start>=s.length())  
    {  
        res.add(item);  
        return;  
    }  
    StringBuilder str = new StringBuilder();  
    for(int i=start;i<s.length();i++)  
    {  
        str.append(s.charAt(i));  
        if(dict.contains(str.toString()))  
        {  
            String newItem = item.length()>0?(item+" "+str.toString()):str.toString();  
            helper(s,dict,i+1,newItem,res);  
        }  
    }  
}

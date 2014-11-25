//delete char which in pattern
import java.util.HashSet;

public class Solution {
    public String deleteString(String str,String p) {
    	if(p==null || p.length()==0)
    	    return str;
    	HashSet<Character> set = new HashSet<Character>();
    	for(int i=0;i<p.length();i++)
    	    set.add(p.charAt(i));
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<str.length();i++){
    	    char c = str.charAt(i);
    	    if(!set.contains(c))
    		sb.append(c);
    	}
    	return sb.toString();
    }

    public static void main(String[] args) {
	String str = "abcedfghjikl";
	String p = "ab";
	System.out.println(new Solution().deleteString(str, p));
	str = "aababbabskdjasbababab";
	p = "ab";
	System.out.println(new Solution().deleteString(str, p));
    }
}

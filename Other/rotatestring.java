//"abcedf" m = 3 edfabc

public class Solution{
	//O(m+n)
	public static String rotateStr1(String str,int m){
		while(m>0){
			str = inserttoLast(str);
			m--;
		}
		return str;
	}
	public static String inserttoLast(String str){
		if(str==null || str.length()==0)
			return str;
		return str.substring(1)+str.charAt(0);
	}
	
	public static void main (String[] args){
		System.out.println(rotateStr1("abcdef",3));
	}
	
	
}

//输出所有1的个数为k的n位二进制数(k<n)
import java.util.ArrayList;

public class Solution {
    public static ArrayList<String> getKN(int k,int n){
    	ArrayList<String> res = new ArrayList<String>();
    	if(k>n)
    	    return res;
    	String str = "";
    	helper(res,str,k,n);
    	return res;
    }
    public static void helper(ArrayList<String> res, String buffer,int k,int n){
    	if(k<0 || n<0)
    	    return;
    	if(n==0 && k==0){
    	    res.add(buffer);
    	    return;
	}
    	if(k>0)
    	    helper(res,buffer +"1",k-1,n-1);
    	helper(res,buffer+"0",k,n-1);    
    }
    public static void main(String[] args) {
    	ArrayList<String> res = getKN(2,4);
    	System.out.println(res);
    }

}

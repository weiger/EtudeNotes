/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.

 * Note: The numbers can be arbitrarily large and are non-negative. 
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int[] d = new int[num1.length()+num2.length()];
    	String n1 = new StringBuffer(num1).reverse().toString();
    	String n2 = new StringBuffer(num2).reverse().toString();

    	for(int i=0;i<n1.length();i++){
    	   for(int j =0;j<n2.length();j++){
    	       d[i+j] += (n1.charAt(i)-'0')*(n2.charAt(j)-'0');
    	   }
    	}
    	StringBuffer sb = new StringBuffer();
    	for(int i=0;i<d.length;i++){
    	    int digit = d[i]%10;
    	    int cin = d[i]/10;
    	    if(i+1<d.length)
    		d[i+1]+=cin;
    	    sb.insert(0, digit);
    	}
    	while(sb.charAt(0)=='0'&&sb.length()>1){
    	    sb.deleteCharAt(0);
    	}
    	return sb.toString();
    }
}

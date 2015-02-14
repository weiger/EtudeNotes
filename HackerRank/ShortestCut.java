import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	public static int solve(String str){
		char[] arr = str.toCharArray();
		int beg = 0;
		int end = str.length() - 1;
		while(beg < end){
			char tmp = arr[beg];
			arr[beg] = arr[end];
			arr[end] = tmp;
			beg++;
			end--;
		}
		String newstr = new String(arr);
		return str.length() - LCS(str, newstr);
	}
	
	public static int LCS(String a, String b){
		int[][] dp = new int[a.length()+1][b.length()+1];
		dp[0][0] = 0;
		for(int i = 0 ; i <= a.length(); i++){
			for(int j = 0 ; j <= b.length(); j++){
				if(i == 0 || j == 0){
					dp[i][j] = 0;
				}else{
					if(a.charAt(i - 1) == b.charAt(j - 1)){
						dp[i][j] = dp[i - 1][j - 1] + 1;
 					}else{
 						dp[i][j] = dp[i - 1][j - 1];
 					}
				}
			}
		}
		return dp[a.length()][b.length()];
	}
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = Integer.parseInt(cin.nextLine());
        for(int i = 0 ; i < N; i++){
        	System.out.println(solve(cin.nextLine()));
        }
    }
}

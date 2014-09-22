//http://poj.org/problem?id=1159
//区间dp.dp[a][b] means steps from substring(a,b)
public class PalidromeSolution {
    public static int stepstopal(String s){
  	int[][] dp = new int[s.length()][s.length()];
  	for(int i = 0;i<s.length();i++){
  	    dp[i][i] = 0;
  	    if(i!=s.length()-1){
  		dp[i][i+1] = s.charAt(i)==s.charAt(i+1)?0:1;
  	    }		
  	}
  	for(int i=2;i<=s.length();i++){
  	    for(int j=0;j<s.length()-i;j++){
  		if(s.charAt(j)==s.charAt(j+i))
  		    dp[j][j+i] = dp[j+1][j+i-1];
  		else
  		    dp[j][j+i] = Math.min(dp[j+1][j+i], dp[j][j+i-1]) + 1;
  	    }
  	}
  	/*for(int i=0;i<dp.length;i++){
  	    for(int j =0;j<dp[0].length;j++)
  		System.out.print(dp[i][j]+" ");
  	    System.out.println();
  	}*/
	   
	  return dp[0][s.length()-1];
    }
    
    public static void main(String[] args) {
	    System.out.println(stepstopal("Ab3bd")); 
    }
}

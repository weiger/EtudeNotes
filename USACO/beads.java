/*Dynamic Programming is good method for solving this problem in O(N). If we consider two copies of the string we easy 
transform cyclic configuration of the necklace to linear. Now we can compute for each breaking point how many beads of the same
color can be collected on the left and on the right from the breaking point. I show how we can compute it only for the left side
For right side it is analogical. Let r[p] and b[p] be the number of red / blue beads that can be collected, when necklace is 
broken in point p. If we know this and color of next bead (c) we can compute r[p+1] and b[p+1].
 r[0] = p[0] = 0
 If c = 'r' then r[p+1] = r[p] + 1 and b[p+1] = 0
        because the length of the blue beads is 0.
 if c = 'b' then b[p+1] = b[p] + 1 and r[p+1] = 0
 if c = 'w' then both length of the red and length of blue beads
             can be longer.
so r[p+1] = r[p]+1 and b[p+1] = b[p] + 1.
The number of beads that can be collected in breaking point p is then 
max(left[r[p]], left[b[p]]) + max(right[r[p]], right[b[p]])
. And the maximum from this value is answer for the problem.*/
import java.io.*;
import java.util.*;

/*
ID:yixiaom1
LANG:JAVA
TASK:beads
*/
public class beads {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = new Scanner(new File("beads.in"));
        PrintWriter cout = new PrintWriter(new File("beads.out"));
        int len=Integer.parseInt(cin.nextLine());
        String str=cin.nextLine();
        str = str+str;
        int[][] dp1 = new int[2*len+1][2];
        int[][] dp2 = new int[2*len+1][2];
        dp1[0][0] = 0;dp1[0][1]=0;
        for(int i=1;i<=2*len;i++){
            if(str.charAt(i-1)=='r'){
                dp1[i][0] = dp1[i-1][0] + 1;
                dp1[i][1] = 0;
            }else if(str.charAt(i-1)=='b'){
                dp1[i][1] = dp1[i-1][1] + 1;
                dp1[i][0] = 0;
            }else{
                dp1[i][0] = dp1[i-1][0] + 1;
                dp1[i][1] = dp1[i-1][1] + 1;
            }
        }
        dp2[2*len][0] = 0;dp1[2*len][1]=0;
        for(int i=2*len-1;i>0;i--){
            if(str.charAt(i)=='r'){
                dp2[i][0] = dp2[i+1][0] + 1;
                dp2[i][1] = 0;
            }else if(str.charAt(i)=='b'){
                dp2[i][1] = dp2[i+1][1] + 1;
                dp2[i][0] = 0;
            }else{
                dp2[i][0] = dp2[i+1][0] + 1;
                dp2[i][1] = dp2[i+1][1] + 1;
            }
        }
        int res = 0;
        for(int i=1;i<2*len;i++){
            res = Math.max(res, Math.max(dp1[i][0],dp1[i][1])+Math.max(dp2[i][0],dp2[i][1]));
        }
        res = Math.min(res, len);
        cout.println(res);
        cout.close();
    }

}

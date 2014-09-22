/*
N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，则他们的身高满足T1<...<Ti>Ti+1>…>TK(1<=i<=K)。你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 
输入格式：
输入的第一行是一个整数N(2<=N<=100)，表示同学的总数。第一行有n个整数，用空格分隔，第i个整数Ti(130<=Ti<=230)是第i位同学的身高(厘米)。
 
输出格式：
输出包括一行，这一行只包含一个整数，就是最少需要几位同学出列。
 
输入样例：
8
186 186 150 200 160 130 197 220
 
输出样例：
4
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    
    public static int chrous(int[] data){
        int len = data.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        for(int i=0;i<len;i++)
            dp1[i]=dp2[i]=1;
    for(int i=0;i<len;i++)  //forward LIS
    for(int j=0;j<i;j++)
        if(data[i]>data[j])
            dp1[i] = Math.max(dp1[i],dp1[j]+1);
        for(int i=len-1;i>=0;i--)
            for(int j=len-1;j<i;j--)
                if(dp2[i]>dp2[j])
                    dp2[i] = Math.max(dp2[i], dp2[j]+1);
                int res = 0;
                for(int i=0;i<len;i++)
                    res = Math.max(res, dp1[i]+dp2[i]);
                return len-res+1;
            }

            public static void main(String[] args) {
                int[] data = {186,186,150,200,160,130,197,220};
                int res = chrous(data);
                System.out.println(res);
                
            }
        }

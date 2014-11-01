
public class Solution {
    public static int updateBits(int n, int m, int i, int j){
        if(j>=32||i>j)
            return 0;
        int left = (~0)<<(j+1);
        int right = (1<<(i+1))-1;
        int mask = left|right;
        n = n & mask;
        m = m << i;
        return m|n;
        
    }
    public static void main(String[] args) {
        int a = 103217;
        System.out.println(Integer.toBinaryString(a));
        int b = 13;
        System.out.println(Integer.toBinaryString(b));      
        int c = updateBits(a, b, 4, 12);
        System.out.println(Integer.toBinaryString(c));
    }
}

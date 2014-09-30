/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can 
 * you climb to the top?
 */
/*n steps to top means n slot
 so n =4 it's 0 - 1 - 2 - 3 - 4  size of array is n + 1*/
 
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++) 
            res[i] = res[i - 1] + res[i - 2];
        return res[n];
    }

    public int climbStairs(int n) {
        int a = 0, b = 1, res = 1;
        for(int i = 1; i <= n; i++) {
            res = a + b;
            a = b; 
            b = res;
        }
        return res;
    }
}

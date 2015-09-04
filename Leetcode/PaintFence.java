public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0){
            return 0;
        }
        if(n == 1){
            return k;
        }
        int[] diff = new int[n + 1];
        int[] same = new int[n + 1];
        diff[2] = k * (k - 1);
        same[2] = k;
        for(int i = 3; i <= n; i++){
            same[i] = diff[i - 1];
            diff[i] = (same[i - 1] + diff[i- 1]) * (k - 1);
        }
        return same[n] + diff[n];
    }
}

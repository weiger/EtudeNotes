public class Solution {
    public int nthUglyNumber(int n) {
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            int m2 = res[idx2] * 2;
            int m3 = res[idx3] * 3;
            int m5 = res[idx5] * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            res[i] = min;
            if(min == m2){
                idx2++;
            }
            if(min == m3){
                idx3++;
            }
            if(min == m5){
                idx5++;
            }
        }
        return res[n - 1];
    }
}

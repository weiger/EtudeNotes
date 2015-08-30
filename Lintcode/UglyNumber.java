class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        int idx3 = 0;
        int idx5 = 0;
        int idx7 = 0;
        long[] res = new long[k + 1];
        res[0] = 1;
        for(int i = 1; i <= k; i++){
            long m3 = res[idx3] * 3;
            long m5 = res[idx5] * 5;
            long m7 = res[idx7] * 7;
            long min = Math.min(m3, Math.min(m5, m7));
            res[i] = min;
            if(min == m3){
                idx3++;
            }
            if(min == m5){
                idx5++;
            }
            if(min == m7){
                idx7++;
            }
        }
        return res[k];
    }
};


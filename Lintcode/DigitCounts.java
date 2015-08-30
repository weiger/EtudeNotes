class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int res  = 0;
        for(int i = 0 ; i <= n; i++){
            int m = i;
            while(m != 0){
                if(m % 10 == k){
                    res++;
                }
                m /= 10;
            }
        }
        return res;
    }
};


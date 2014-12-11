/*
Write an algorithm which computes the number of trailing zeros in n factorial.
Example
11! = 39916800, so the out should be 2
*/
//TLE
class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        int t = 0;
        int f = 0;
        for(int i=1;i<=n;i++){
            int tmp1 = i;
            while(tmp1%2==0){
                t++;
                tmp1 = tmp1/2;
            }
            int tmp2 = i;
            while(tmp2%5==0){
                f++;
                tmp2 = tmp2/5;
            }
        }
        return Math.min(t,f);
    }
};

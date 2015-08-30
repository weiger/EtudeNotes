class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        long cnt = 0;
        while(n != 0){
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }
};


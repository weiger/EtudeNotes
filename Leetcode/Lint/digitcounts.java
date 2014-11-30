*/
Count the number of k's between 0 and n. k can be 0 - 9.

Example
if n=12, in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12], we have FIVE 1's (1, 10, 11, 12)
*/

class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        int res = 0;
        for(int i=0;i<=n;i++){
            int v = i;
            while(v!=0){
                if(v%10==k)
                    res++;
                v=v/10;
            }
        }
        return res;
    }
};


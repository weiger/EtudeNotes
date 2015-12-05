/*
Ex: 6, [2,5,7]
1. [1]           min(1*2, 1*5, 1*7)
  2,5,7
2. [1,2]         min(2*2, 1*5, 1*7)
  5,7 2
3. [1,2,4]       min(4*2, 1*5, 1*7) 
  5,7   2
4. [1,2,4,5]     min(4*2, 2*5, 1*7) 
    7 5 2
5. [1,2,4,5,7]   min(4*2, 2*5, 2*7)
     5,7 2
6. [1,2,4,5,7,8] min(5*2, 2*5, 2*7)
     5,7  2
*/
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 1;
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < primes.length; j++) {
                res[i] = Math.min(res[i], primes[j] * res[index[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (res[i] == primes[j] * res[index[j]]) {
                    index[j]++;
                }
            }
        }
        return res[n - 1];
    }
}

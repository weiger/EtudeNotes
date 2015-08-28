public class Solution {
    public int countPrimes(int n) {
        int cnt = 0;
        for(int i = 1 ; i < n; i++){
            if(isPrime(i)){
                cnt++;
            }
        }
        return cnt;
    }
    public boolean isPrime(int n) {
        if(n == 1) return false;
        if(n == 2) return true;
        if (n % 2 == 0) return false;
        for(int i = 3; i *  i<= n;i += 2) {
            if(n % i==0)
                return false;
        }
        return true;
    }
}

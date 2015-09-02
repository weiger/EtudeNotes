class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        int a = 0; int b = 1; int c = 0;
        if(n == 1) return a;
        if(n == 2) return b;
        for(int i = 2 ; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

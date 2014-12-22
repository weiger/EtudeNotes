/*
implement int sqrt(int x).

Compute and return the square root of x.
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        if(x < 0)
            return 0;
        long last = 0;
        long res = x;
        while(last != res){
            last = res;
            res = (res + x / res) / 2;
        }
        return (int)res;
    }
}

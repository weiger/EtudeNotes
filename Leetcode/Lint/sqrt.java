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

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        int beg = 1;
        int end = x;
        while(beg <= end){
            int mid = beg + (end - beg) / 2;
            if( x / mid >=mid ){
                beg = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return beg - 1;
    }
}

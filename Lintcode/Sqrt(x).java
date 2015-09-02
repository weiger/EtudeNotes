class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        long beg = 0;
        long end = x;
        while(beg <= end){
            long mid = beg + (end - beg) / 2;
            if(mid * mid == x){
                return (int)mid;
            }else if(mid * mid > x){
                end = mid - 1;
            }else{
                beg = mid + 1;
            }
        }
        return (int)end;
    }
}
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        long last = 0;
        long cur = x;
        while(cur != last){
            last = cur;
            cur = (cur + x / cur) / 2;
        }
        return (int)cur;
    }
}

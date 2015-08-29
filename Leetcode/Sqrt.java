/*
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */
/*
判断非零，用double,迭代公式next = (cur + x/cur)/2 当last==next 结束
*/
public class Solution {
    public int sqrt(int x) {
        if(x<0)
            return 0;
        double last = 0;
        double res = x;
        while(last!=res){
            last = res;
            res = (res + x/res)/2;
        }
        return (int)res;
    }
}

public class Solution {
    public int mySqrt(int x) {
        long beg = 0;
        long end = x;
        while(beg <= end){
            long mid = beg + (end - beg) / 2;
            if( mid * mid == x){
                return (int)mid;
            }else if(mid * mid < x){
                beg = mid + 1;
            }else if(mid * mid > x){
                end = mid - 1;
            }
        }
        return (int)end;
    }
}

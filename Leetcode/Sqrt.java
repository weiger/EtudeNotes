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
    public int sqrt(int x) {
        if(x<0) return 0;
        long beg = 0;
        long end = x/2 + 1;
        while(beg<=end){
            long mid = (beg + end)/2;
            long sq = mid * mid;
            if(sq == x) return (int)mid;
            else if(sq<x){
                beg = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return (int)end;
    }
}

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
/*brutal O(n^2)
1.注意扫描时避开基准
2.扫描是记录完全相同的点
3.注意K正无穷时候
4.HashMap奇数，每次循环结束后注意清空
*/
public class Solution {
    public int maxPoints(Point[] points) {
        if(points==null || points.length==0)
            return 0;
        HashMap<Double,Integer> map = new HashMap<Double,Integer>();
        int max = 1;
        double k;
        for(int i=0;i<points.length;i++){
            int count = 1;
            map.clear();
            for(int j=0;j<points.length;j++){
                if(points[j]==points[i]){
                    continue;
                }
                if(points[j].x==points[i].x && points[j].y==points[i].y){
                    count++;continue;
                }
                if(points[j].x==points[i].x && points[j].y!=points[i].y){
                    k = Integer.MAX_VALUE;
                }else{
                    k = ((double)points[j].y-(double)points[i].y)/((double)points[j].x-(double)points[i].x);
                }
                if(map.containsKey(k)){
                    map.put(k,map.get(k)+1);
                }else{
                    map.put(k,1);
                }
            }
            int tmp = 0;
            for(Integer x:map.values()){
                tmp = Math.max(x,tmp);
            }
            max = Math.max(max,tmp+count);
        }
        return max;
    }
}

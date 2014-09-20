/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
//brutal O(n^2)
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length==0) return 0;
        if(points.length==1 || points.length==2) return points.length;
        HashMap<Double,Integer> map = new HashMap<Double,Integer>();
        int max = 1;
        int temp = 1;
        double k;
        for(int i=0;i<points.length;i++){
            temp=1;
            map.clear();
            Point p1 = points[i];
            for(int j=0;j<points.length;j++){
                Point p2 = points[j];
                if(p1==p2) continue;
                if(p1.x==p2.x && p1.y==p2.y){
                    temp++;continue;
                } 
                
                if(p1.x==p2.x) 
                    k=Integer.MAX_VALUE;
                else
                    k=((double)p1.y-(double)p2.y)/((double)p1.x-(double)p2.x);    
                
                if(map.containsKey(k))
                    map.put(k,map.get(k)+1);
                else
                    map.put(k,1);
            }
            int count = 0;
            for(Integer x:map.values()){
                if(x>count)
                    count=x;
            }
            count+=temp;
            if(count>max)
                max=count;
        }
        return max;
    }
}

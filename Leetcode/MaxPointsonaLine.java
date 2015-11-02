/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
/*
1. Dup统计重和点
2. Ver统计K为正无穷的点
3. 其他点Hash统计，double 分0.0 和 -0.0
4. 别忘清空Hash
*/
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        HashMap<Double, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int vertical = 0;
            int dup = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        dup++;
                    } else {
                        vertical++;
                    }
                } else {
                    double slope;
                    if (points[j].y == points[i].y) {
                        slope = 0.0;
                    } else {
                        slope = (1.0) * (points[j].y - points[i].y) / (points[j].x - points[i].x);
                    }
                    if (!map.containsKey(slope)) {
                        map.put(slope, 1);
                    } else {
                        map.put(slope, map.get(slope) + 1);
                    }
                }
            }
            for (Integer val: map.values()) {
                res = Math.max(res, dup + val);
            }
            res = Math.max(res, dup + vertical);
            map.clear();
        }
        return res;
    }
}

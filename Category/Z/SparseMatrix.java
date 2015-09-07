import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {
    public Map<Point, Integer> trans(int[][] m){
        Map<Point, Integer> map = new HashMap<>();
        for(int i = 0; i < m.length; i++){
            for(int j = 0 ; j < m[0].length; j++){
                if(m[i][j] != 0){
                    Point newpoint = new Point(i,j);
                    map.put(newpoint, m[i][j]);
                }
            }
        }
        return map;
    }
    public Map<Point, Integer> add(Map<Point, Integer> add1, Map<Point, Integer> add2){
        Map<Point, Integer> res = new HashMap<>();
        for(Point point: add1.keySet()){
            if(add2.containsKey(point)){
                res.put(point, add1.get(point) + add2.get(point));
            }
        }
        return res;
    }
    public Map<Point, Integer> mux(Map<Point, Integer> mux1, Map<Point, Integer> mux2){
        Map<Point, Integer> res = new HashMap<>();
        for(Point p1: mux1.keySet()){
            for(Point p2: mux2.keySet()){
                if(p1.y == p2.x){
                    Point p = new Point(p1.x, p2.y);
                    if(!res.containsKey(p)){
                        res.put(p, mux1.get(p1) * mux2.get(p2));
                    }else{
                        res.put(p, res.get(p) + mux1.get(p1) * mux2.get(p2));
                    }
                }
            }
        }
        return res;
    }
    public void print(Map<Point, Integer> matrix, int m, int n){
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                Point tmp = new Point(i, j);
                if(matrix.containsKey(tmp)){
                    System.out.print(matrix.get(tmp) + " ");
                }else{
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] m1 = {
                {1,0,0},
                {0,2,0},
                {0,0,3}
        };
        int[][] m2 = {
                {1,0,0},
                {0,2,0},
                {0,0,3}
        };
        int m = m1.length; int n = m1[0].length;
        Map<Point, Integer> map1 = s.trans(m1);
        Map<Point, Integer> map2 = s.trans(m2);
        Map<Point, Integer> res1 = s.add(map1, map2);
        Map<Point, Integer> res2 = s.mux(map1, map2);
        s.print(res1, m, n);
        s.print(res2, m, n);
    }
}

class Point{
    int x; int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode(){
        return 10 * x + y;
    }
    @Override
    public boolean equals(Object obj){
        Point other = (Point)obj;
        return x == other.x && y == other.y;
    }
    public String toString(){
        return x + "," + y;
    }
}

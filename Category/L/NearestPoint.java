public class Solution {
    List<Point> list = new ArrayList<>();

    public void addPoint(Point p){
        list.add(p);
    }

    public List<Point> findNearest(Point center, int p){
        HashMap<Integer, Point> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(p, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (Point e: list) {
            int dist = (int)Math.sqrt(Math.pow(e.x - center.x, 2) + Math.pow(e.y - center.y, 2));
            if (pq.size() < p) {
                pq.offer(dist);
            } else {
                if (dist < pq.peek()) {
                    pq.poll();
                    pq.offer(dist);
                }
            }
            map.put(dist, e);
        }
        List<Point> res = new ArrayList<>();
        while (pq.size() != 0) {
            res.add(map.get(pq.poll()));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.addPoint(new Point(0, 1));
        s.addPoint(new Point(0, 2));
        s.addPoint(new Point(0, 3));
        s.addPoint(new Point(0, 4));
        s.addPoint(new Point(0, 5));
        System.out.println(s.findNearest(new Point(0,0), 3));
    }
}
class Point {
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode(){
        return x * 10 + y;
    }
    @Override
    public boolean equals(Object o){
        Point other = (Point)o;
        return x == other.x && y == other.y;
    }
    public String toString() {
        return x + " : " + y;
    }
}

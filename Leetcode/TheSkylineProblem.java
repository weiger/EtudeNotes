public class Solution {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return result;
        }
        Comparator<Point> comp = new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                if (a.x != b.x) {
                    return a.x - b.x;
                } else {
                    return a.y - b.y;
                }
            }
        };
        PriorityQueue<Point> pq = new PriorityQueue<>(5, comp);
        for (int[] data: buildings) {
            pq.add(new Point(data[0], -data[2]));
            pq.add(new Point(data[1], data[2]));
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);
        int max = 0;
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.y < 0) {
                if (!map.containsKey(-cur.y)) {
                    map.put(-cur.y, 0);
                }
                map.put(-cur.y, map.get(-cur.y) + 1);
            } else {
                map.put(cur.y, map.get(cur.y) - 1);
                if (map.get(cur.y) == 0) {
                    map.remove(cur.y);
                }
            }
            int curMax = map.lastEntry().getKey();
            if (curMax != max) {
                result.add(new int[]{cur.x, curMax});
                max = curMax;
            }
        }
        return result;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

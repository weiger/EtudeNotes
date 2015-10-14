public class Solution {

    public List<Integer> findPair(int[][] A) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Point> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (!map.containsKey(A[i][j])) {
                    map.put(A[i][j], new Point(i, j));
                } else {
                    res.add(A[i][j]);
                    res.add(map.get(A[i][j]).x);
                    res.add(map.get(A[i][j]).y);
                    res.add(i);
                    res.add(j);
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 4}
        };
        List<Integer> res = test.findPair(A);
        System.out.println(res);
    }
}

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return x + " : " + y;
    }
}

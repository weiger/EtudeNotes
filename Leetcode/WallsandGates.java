public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;

        for (int i = 0 ; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i,j);
                }
            }
        }
    }
    
    public void bfs (int[][] rooms, int i, int j){
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        rq.offer(i);
        cq.offer(j);
        int cur = 1;
        int next = 0;
        int level = 1;
        while (!rq.isEmpty() && !cq.isEmpty()) {
            int row = rq.poll();
            int col = cq.poll();
            cur--;
            if (row - 1 >= 0 && rooms[row - 1][col] > level) {
                rooms[row - 1][col] = level;
                rq.offer(row - 1);cq.offer(col);
                next++;
            }
            if (row + 1 < rooms.length && rooms[row + 1][col] > level) {
                rooms[row + 1][col] = level;
                rq.offer(row + 1);cq.offer(col);
                next++;
            }
            if (col - 1 >= 0 && rooms[row][col - 1] > level) {
                rooms[row][col - 1] = level;
                rq.offer(row);cq.offer(col - 1);
                next++;
            }
            if (col + 1 < rooms[0].length && rooms[row][col + 1] > level) {
                rooms[row][col + 1] = level;
                rq.offer(row);cq.offer(col + 1);
                next++;
            }
            if (cur == 0) {
                cur = next;
                next = 0;
                level++;
            }
        }
    }
}

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        for (int i = 0 ; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    rq.offer(i);
                    cq.offer(j);
                }
            }
        }
        int INF = Integer.MAX_VALUE;
        while (!rq.isEmpty() && !cq.isEmpty()) {
            int row = rq.poll();
            int col = cq.poll();
            int num = rooms[row][col];
            if (row - 1 >= 0 && rooms[row - 1][col] == INF) {
                rooms[row - 1][col] = num + 1;
                rq.offer(row - 1);cq.offer(col);
            }
            if (row + 1 < rooms.length && rooms[row + 1][col] == INF) {
                rooms[row + 1][col] = num + 1;
                rq.offer(row + 1);cq.offer(col);
            }
            if (col - 1 >= 0 && rooms[row][col - 1] == INF) {
                rooms[row][col - 1] = num + 1;
                rq.offer(row);cq.offer(col - 1);
            }
            if (col + 1 < rooms[0].length && rooms[row][col + 1] == INF) {
                rooms[row][col + 1] = num + 1;
                rq.offer(row);cq.offer(col + 1);
            }
        }
    }
}

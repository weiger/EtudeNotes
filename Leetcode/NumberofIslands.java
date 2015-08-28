/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.
Example 1:
11110
11010
11000
00000
Answer: 1
Example 2:
11000
11000
00100
00011
Answer: 3
*/
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int cnt = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
    public void dfs(char[][] grid, int x, int y){
        grid[x][y] = '0';
        if(x - 1 >= 0 && grid[x - 1][y] == '1'){
            dfs(grid, x - 1, y);
        }
        if(x + 1 < grid.length && grid[x + 1][y] == '1'){
            dfs(grid, x + 1, y);
        }
        if(y - 1 >= 0 && grid[x][y - 1] == '1'){
            dfs(grid, x, y - 1);
        }
        if(y + 1 < grid[0].length && grid[x][y + 1] == '1'){
            dfs(grid, x, y + 1);
        }
    }
    
}

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int cnt = 0;
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void bfs(char[][] grid, int i, int j){
        Queue<Integer> row = new LinkedList<Integer>();
        Queue<Integer> col = new LinkedList<Integer>();
        row.offer(i);
        col.offer(j);
        grid[i][j] = '0';
        while(!row.isEmpty() && !col.isEmpty()){
            int m = row.poll();
            int n = col.poll();

            if(m - 1 >= 0 && grid[m - 1][n] == '1'){
                grid[m - 1][n] = '0';
                row.offer(m - 1); col.offer(n);
            }
            if(m + 1 < grid.length && grid[m + 1][n] == '1'){
                grid[m + 1][n] = '0';
                row.offer(m + 1); col.offer(n);
            }
            if(n - 1 >= 0 && grid[m][n - 1] == '1'){
                grid[m][n - 1] = '0';
                row.offer(m); col.offer(n - 1);
            }
            if(n + 1 < grid[0].length && grid[m][n + 1] == '1'){
                grid[m][n + 1] = '0';
                row.offer(m); col.offer(n + 1);
            }
        }
    }
}

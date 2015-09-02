public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0){
            return 0;
        }
        int cnt = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]){
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }
    
    public void dfs(boolean[][] grid, int i, int j){
        grid[i][j] = false;
        if(i - 1 >= 0 && grid[i - 1][j]) dfs(grid, i - 1, j);
        if(i + 1 < grid.length && grid[i + 1][j]) dfs(grid, i + 1, j);
        if(j - 1 >= 0 && grid[i][j - 1]) dfs(grid, i, j - 1);
        if(j + 1 < grid[0].length && grid[i][j + 1]) dfs(grid, i, j + 1);
    } 
}

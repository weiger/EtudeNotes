class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    int res = 0;
    public int totalNQueens(int n) {
        //write your code here
        int[] chess = new int[n];
        dfs(chess, n, 0);
        return res;
    }

    public void dfs(int[] chess, int n, int deep){
        if(deep == n){
            res++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(isValid(chess, i, deep)){
                int tmp = chess[deep];
                chess[deep] = i;
                dfs(chess, n, deep + 1);
                chess[deep] = tmp;
            }
        }
    }

    public boolean isValid(int[] chess, int num, int deep){
        for(int j = 0; j < deep; j++){
            if(chess[j] == num || deep - j == Math.abs(num - chess[j])){
                return false;
            }
        }
        return true;
    }
};

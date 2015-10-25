public class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    X.add(i);
                    Y.add(j);
                }
            }
        }
        return helper(X) + helper(Y);
    }
    public int helper(List<Integer> list){
        Collections.sort(list);
        int beg = 0, res = 0;
        int end = list.size() - 1;
        while (beg < end) {
            res += list.get(end--) - list.get(beg++);
        }
        return res;
    }
}

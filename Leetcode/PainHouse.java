public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        int a = costs[0][0];
        int b = costs[0][1];
        int c = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int olda = a; int oldb = b;
            a = costs[i][0] + Math.min(b, c);
            b = costs[i][1] + Math.min(olda, c);
            c = costs[i][2] + Math.min(olda, oldb);
        }
        return Math.min(a, Math.min(b, c));
    }
}
public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0)
            return 0;
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}

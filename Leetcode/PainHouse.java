public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        for(int i = 1; i < costs.length; i++){
            int oldred = red;
            int oldgreen = green;
            int oldblue = blue;
            red = Math.min(green, blue) + costs[i][0];
            blue = Math.min(oldred, oldgreen) + costs[i][1];
            green = Math.min(oldred, oldblue) + costs[i][2];
        }
        return Math.min(red, Math.min(green, blue));
    }
}

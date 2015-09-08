public class Solution {
    public int countTriangle(int[][] data){
        if(data == null || data.length == 0){
            return 0;
        }
        return helper1(data);
    }

    public int helper1(int[][] data){
        int cnt = 0;
        for(int i = 0; i < data.length; i++){
            for(int j = i + 1; j < data.length; j++){
                for(int k = j + 1; k < data.length; k++)
                    if (data[i][j] == 1 && data[j][k] == 1 && data[k][i] == 1) {
                        cnt++;
                    }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] data = {
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };
        int res = new Solution().countTriangle(data);
        System.out.println(res);
    }
}

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int res = 0;
        int[][] height = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else {
                    if (i == 0) {
                        height[i][j] = 1;
                    } else {
                        height[i][j] = height[i - 1][j] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < M; i++) {
            res = Math.max(res, largestRectangleArea(height[i]));
        }
        return res;
    }
    // Same as largest rectangle
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int i = 0, max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (i < height.length || !stack.isEmpty()) {
            if (stack.isEmpty() || (i < height.length && height[i] > height[stack.peek()])) {
                stack.push(i++);
            } else {
                int cur = stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, height[cur] * i);
                } else {
                    max = Math.max(max, height[cur] * (i - 1 - stack.peek()));
                }
            }
        }
        return max;
    }
}

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int[] H = new int[N + 1];
        H[0] = 0;
        int res = 0;
        for (int row = 0 ; row < M; row++) {
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0 ; i < N + 1; i++) {
                if (i < N) {
                    if (matrix[row][i] == '1') {
                        H[i] += 1;
                    } else {
                        H[i] = 0;
                    }
                }
                if (stack.isEmpty() || H[stack.peek()] <= H[i]) {
                    ;
                } else {
                    while (!stack.isEmpty() && H[stack.peek()] > H[i]) {
                        int top = stack.pop();
                        int cur = H[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                        res = Math.max(res, cur);
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }
}

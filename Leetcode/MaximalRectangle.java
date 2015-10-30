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
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && H[stack.peek()] > H[i]) {
                        int top = stack.pop();
                        int cur = H[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                        res = Math.max(res, cur);
                    }
                    stack.push(i);
                }    
            }
        }
        return res;
    }
}

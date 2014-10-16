public class Q1_6 {
    public static void rotate1(int[][] matrix) {
	int len = matrix.length;
	for (int i = 0; i < len - 1; i++) {
	    for (int j = 0; j < len - i - 1; j++) {
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[len - j - 1][len - i - 1];
		matrix[len - j - 1][len - i - 1] = tmp;
	    }
	}
	for (int i = 0; i < len / 2; i++) {
	    for (int j = 0; j < len; j++) {
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[len - i - 1][j];
		matrix[len - i - 1][j] = tmp;
	    }
	}
    }

    public static void rotate2(int[][] matrix) {
	int n = matrix.length;
	for (int layer = 0; layer < n / 2; ++layer) {
	    int first = layer;
	    int last = n - 1 - layer;
	    for (int i = first; i < last; ++i) {
		int offset = i - first;
		int top = matrix[first][i]; // save top

		// left -> top
		matrix[first][i] = matrix[last - offset][first];

		// bottom -> left
		matrix[last - offset][first] = matrix[last][last - offset];

		// right -> bottom
		matrix[last][last - offset] = matrix[i][last];

		// top -> right
		matrix[i][last] = top; // right <- saved top
	    }
	}
    }

    public static void main(String[] args) {
	int n = 3;
	int[][] A = new int[n][n];
	for (int i = 0; i < A.length; i++) {
	    for (int j = 0; j < A[0].length; j++) {
		A[i][j] = (int) (10 * Math.random());
		System.out.print(A[i][j] + " ");
	    }
	    System.out.println();
	}
	rotate2(A);
	for (int[] x : A) {
	    for (int y : x)
		System.out.print(y + " ");
	    System.out.println();
	}
    }
}

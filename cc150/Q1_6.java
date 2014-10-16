
public class Q1_6 {
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-i-1;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len-j-1][len-i-1];
                matrix[len-j-1][len-i-1] = tmp;
            }
        }
        for(int i=0;i<len/2;i++){
            for(int j=0;j<len;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[len-i-1][j];
                matrix[len-i-1][j] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] A = new int[n][n];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                A[i][j] =(int)(10 * Math.random());
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
        rotate(A);
        for(int[] x:A){
            for(int y:x)
                System.out.print(y + " ");
            System.out.println();
        }

    }

}

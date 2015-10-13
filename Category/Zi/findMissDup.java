public class Solution {

    public void findMissing(int[] A) {
        int len = A.length;
        byte[] rec = new byte[len / 8];
        for (int x : A) {
            rec[x / 8] |= (1 << (x % 8));
        }
        for (int i = 0; i < rec.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((rec[i] & (1 << j)) == 0) {
                    System.out.println(8 * i + j);
                }
            }
        }
    }

    public void findDuplicate(int[] A) {
        int[] path = new int[1000];
        for (int i = 0; i < A.length; i++) {
            int chunk = (A[i] - 1) / 32;
            int j = (A[i] - 1) % 32;
            if ((path[chunk] & (1 << j)) != 0) {
                System.out.println(A[i]);
            } else {
                path[chunk] |= (1 << j);
            }
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] A = {1, 2, 2, 3, 4};
        test.findDuplicate(A);
        int[] B = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 0};
        test.findMissing(B);
    }
}

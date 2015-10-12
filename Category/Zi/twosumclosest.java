public class Solution {
    public int[] twosumcloset(int[] A) {
        int[] res = new int[2];
        if (A == null || A.length < 2) {
            return new int[0];
        }
        Arrays.sort(A);
        int beg = 0;
        int end = A.length - 1;
        int dis = Integer.MAX_VALUE;
        while (beg < end) {
            int sum = A[beg] + A[end];
            if (sum == 0) {
                res[0] = A[beg];
                res[1] = A[end];
                return res;
            } else {
                if (Math.abs(sum) < dis) {
                    dis = Math.abs(sum);
                    res[0] = A[beg];
                    res[1] = A[end];
                }
                if (sum < 0) {
                    beg++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Solution test = new Solution();
        int[] A = {0, 2, 2, 3, 4, 5, -1};
        int[] res = test.twosumcloset(A);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}

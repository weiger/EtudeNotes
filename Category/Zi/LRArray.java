public class Solution {
    public int LRarray(int[] A){
        int sum = 0;
        for (int x: A) {
            sum += x;
        }
        int cur = 0;
        for (int i = 1; i < A.length;i++) {
            cur += A[i - 1];
            if (cur == sum - A[i] - cur) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] A = {1,2,3,0,1,5};
        System.out.println(test.LRarray(A));
    }
}

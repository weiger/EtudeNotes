public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) return 0;
        Arrays.sort(L);
        int len = L.length;
        int beg = 1;
        int end = L[len - 1];
        int res = 0;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            int sum = 0;
            for (int x: L) {
                sum += x / mid;
            }
            if (sum >= k){
                res = mid;
                beg = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}

public class Solution {
    public static int quickselect(int[] A, int k) {
        if (k <= 0 || k > A.length - 1)
            return -1;
        int beg = 0;
        int end = A.length - 1;
        while (beg < end) {
            int j = partition(A, beg, end);
            if (j < k) beg = j + 1;
            else if (j > k) end = j - 1;
            else return A[j - 1];
        }
        return A[k];
    }

    public static int partition(int[] A, int beg, int end) {
        if (beg > end)
            return -1;
        int index = beg;
        for (int i = beg; i < end; i++) {
            if (A[i] <= A[end])
                swap(A, index++, i);
        }
        swap(A, index, end);
        return index;
    }

    public static void swap(int[] A, int beg, int end) {
        int tmp = A[beg];
        A[beg] = A[end];
        A[end] = tmp;
    }

    public static void main(String[] args) {
        int[] input = {9, 8, 7, 6, 5, 0, 1, 2, 3, 4};
        int idx = (int) (Math.random() * 10);
        System.out.println("The " + idx + " th elements: " + quickselect(input, idx));
    }
}

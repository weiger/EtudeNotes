public class Solution {
    public static void bubblesort(int[] data) {
        for (int i = 0; i < data.length - 1; i++)
            for (int j = 0; j < data.length - 1 - i; j++)
                if (data[j] > data[j + 1])
                    swap(data, j, j + 1);
            }

    public static void selectionsort(int[] data) {
        for (int i = 0; i < data.length; i++)
            for (int j = i; j < data.length; j++)
                if (data[j] < data[i])
                    swap(data, i, j);
            }

    public static void insertionsort(int[] data) {

        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            int j = i;
            while (j > 0 && tmp < data[j - 1]) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = tmp;
        }

     /*for (int i = 1; i < data.length; i++){ 
              for (int j = i - 1; j >= 0 &&data[j] > data[j + 1]; j--) 
                { swap(data, j, j + 1); } 
            }*/

    }

    public static void quickSort(int[] A) {
        quicksorthelper(A, 0, A.length - 1);
    }

    public static void quicksorthelper(int[] A, int beg, int end) {
        if (beg < end) {
            int pivot = A[end];
            int index = beg;
            for (int i = beg; i < end; i++) {
                if (A[i] <= pivot) {
                    swap(A, index++, i);
                }
            }
            swap(A, index, end);
            quicksorthelper(A, beg, index - 1);
            quicksorthelper(A, index + 1, end);
        }
    }

    public static void quicksort(int[] data) {
        quicksorthelper(data, 0, data.length - 1);
    }

    /*public static void quicksorthelper(int[] data, int beg, int end) {
    if (beg >= end)
        return;
    int index = beg;
    for (int i = beg; i < end; i++) {
        if (data[i] <= data[end])
        swap(data, i, index++);
    }
    swap(data, index, end);
    quicksorthelper(data, beg, index - 1);
    quicksorthelper(data, index, end);
    }*/

    public static void heapSort(int[] A) {
        heapfy(A, A.length);
        int end = A.length - 1;
        while (end >= 0) {
            int tmp = A[0];
            A[0] = A[end];
            A[end] = tmp;
            end--;
            sinkDown(A, 0, end);
        }
    }

    public static void heapfy(int[] A, int len) {
        int beg = (len - 2) / 2;
        while (beg >= 0) {
            sinkDown(A, beg, len - 1);
            beg--;
        }
    }

    public static void sinkDown(int[] A, int beg, int end) {
        int root = beg;
        while (2 * root + 1 <= end) {
            int child = 2 * root + 1;
            if (child + 1 <= end && A[child] < A[child + 1])
                child++;
            if (A[root] < A[child]) {
                int tmp = A[root];
                A[root] = A[child];
                A[child] = tmp;
                root = child;
            } else
            return;
        }
    }

    public static void mergesort(int[] data) {
        int[] helper = new int[data.length];
        mergersorthelper(data, helper, 0, data.length - 1);
    }

    public static void mergersorthelper(int[] data, int[] helper, int beg,
        int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergersorthelper(data, helper, beg, mid);
            mergersorthelper(data, helper, mid + 1, end);
            merge(data, helper, beg, mid, end);
        }
    }

    public static void merge(int[] data, int[] helper, int beg, int mid, int end) {
        for (int i = 0; i <= end; i++) {
            helper[i] = data[i];
        }
        int i = beg;
        int j = mid + 1;
        int k = beg;
        while (i <= mid && j <= end) {
            if (helper[i] <= helper[j]) {
                data[k] = helper[i];
                i++;
            } else {
                data[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            data[k] = helper[i];
            i++;
            k++;
        }
    }

    public static void countingSort(int[] A, int beg, int end) {
        int[] rec = new int[end];
        for (int i = 0; i < A.length; i++) {
            rec[A[i]]++;
        }
        int index = 0;
        for (int i = 0; i < rec.length; i++) {
            while (rec[i] > 0) {
                A[index++] = i;
                rec[i]--;
            }
        }
    }

    public static int[] radixSort(int[] old) {
        for (int shift = Integer.SIZE - 1; shift >= 0; shift--) {
            int[] tmp = new int[old.length];
            int j = 0;
            for (int i = 0; i < old.length; i++) {
                boolean move = old[i] << shift >= 0;

                if (shift == 0 ? !move : move) {
                    tmp[j] = old[i];
                    j++;
                } else {
                    old[i - j] = old[i];
                }
            }
            for (int i = j; i < tmp.length; i++) {
                tmp[i] = old[i - j];
            }
            old = tmp;
        }
        return old;
    }

    public static int[] generate(int n, int beg, int end) {
        int[] A = new int[n];
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (beg + Math.random() * (end - beg));
        }
        return A;
    }

    public static int[] generatearray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * 20);
        }
        return array;
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public static void main(String[] args) {
        int[] data = generate(10, 0, 20);
        print(data);
        // countingSort(data,0,10);
        data = radixSort(data);
        print(data);

    }
}

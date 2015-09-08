import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int[] mergeKSortedArray(int[][] arr){
        PriorityQueue<ArrayContainer> pq = new PriorityQueue<>(10, new Comparator<ArrayContainer>() {
            @Override
            public int compare(ArrayContainer o1, ArrayContainer o2) {
                return o1.arr[o1.index] - o2.arr[o2.index];
            }
        });
        int totalSize = 0;
        for(int i = 0; i < arr.length; i++){
            pq.add(new ArrayContainer(arr[i], 0));
            totalSize += arr[i].length;
        }

        int[] res = new int[totalSize];
        int index = 0;
        while(!pq.isEmpty()){
            ArrayContainer cur = pq.poll();
            res[index++] = cur.arr[cur.index];
            if(cur.index + 1 < cur.arr.length){
                pq.offer(new ArrayContainer(cur.arr, cur.index + 1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int[] arr2 = { 2, 4, 6, 8 };
        int[] arr3 = { 0, 9, 10, 11 };

        int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
        System.out.println(Arrays.toString(result));
    }
}

class ArrayContainer {
    int[] arr;
    int index;

    public ArrayContainer(int[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public int[] getTopK1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return null;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.offer(nums[i]);
            } else if (pq.size() == k) {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public int[] getTopK2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return null;
        }

        int K = kthLargestElement(k, nums);
        System.out.println(K);
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= K) {
                res[index++] = nums[i];
            }
        }
        return res;
    }


    public int kthLargestElement(int k, int[] numbers) {
        // write your code here
        if(k < 1 || k > numbers.length){
            return -1;
        }
        int beg = 0; int end = numbers.length - 1;
        while(beg < end){
            int n = partition(numbers, beg, end);
            if(n == (k - 1)){
                return numbers[k - 1];
            }else if(n < (k - 1)){
                beg = n + 1;
            }else if(n > (k - 1)){
                end = n - 1;
            }
        }
        return numbers[k - 1];
    }

    public int partition(int[] numbers, int beg, int end){
        if(beg > end){
            return -1;
        }
        int index = beg;
        int pivot = numbers[end];
        for(int i = beg; i < end; i++){
            if(numbers[i] >= pivot){
                swap(numbers, index++, i);
            }
        }
        swap(numbers, index, end);
        return index;
    }

    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {9, 8, 3, 5, 11};
        int[] res1 = new Solution().getTopK1(nums, 3);
        int[] res2 = new Solution().getTopK2(nums, 3);
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
    }
}

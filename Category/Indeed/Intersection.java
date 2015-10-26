import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public List<Integer> getIntersection1(int[] A, int[] B) {
        List<Integer> res = new ArrayList<>();
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return res;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int e : A) {
            set.add(e);
        }
        for (int e : B) {
            if (set.contains(e)) {
                res.add(e);
            }
        }
        return res;
    }

    public List<Integer> getIntersection2(int[] A, int[] B) {
        List<Integer> res = new ArrayList<>();
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return res;
        }
        int indexA = 0, indexB = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA] == B[indexB]) {
                res.add(A[indexA]);
                indexA++;
                indexB++;
            } else if (A[indexA] < B[indexB]) {
                indexA++;
            } else if (A[indexA] > B[indexB]) {
                indexB++;
            }
        }
        return res;
    }

    public List<Integer> getIntersection3(int[] A, int[] B) {
        List<Integer> res = new ArrayList<>();
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            return res;
        }
        int indexA = 0, indexB = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA] == B[indexB]) {
                res.add(A[indexA]);
                while (indexA + 1 < A.length && A[indexA] == A[indexA + 1] ) {
                    indexA++;
                }
                while (indexB + 1 < B.length && B[indexB] == B[indexB + 1]) {
                    indexB++;
                }
                indexA++;
                indexB++;
            } else if (A[indexA] < B[indexB]) {
                indexA++;
            } else if (A[indexA] > B[indexB]) {
                indexB++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {3, 4, 5, 6, 7};
        int[] C = {3, 4, 5, 5, 6};
        int[] D = {5, 5, 6, 6, 7};

        System.out.println(s.getIntersection1(A, B));
        System.out.println(s.getIntersection2(A, B));
        System.out.println(s.getIntersection3(C, D));
    }
}

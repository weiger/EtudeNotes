import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) {

        String res = findMinContainingWindow("ADOBECODEBANC", "ABCD");

        if (res == null) {
            System.out.println("No window found.");
        } else {
            System.out.print("The following window is smallest: [" + res + "]");
        }
    }

    public static String findMinContainingWindow(String S, String T) {
        if (S == null || T == null) {
            return null;
        }

        int M = S.length();
        int N = T.length();

        if (M == 0 || M == 0 || N > M) {
            return null;
        }

        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            char c = S.charAt(i);

            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }
        }

        List<List<Integer>> indexList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char c = T.charAt(i);
            if (map.containsKey(c)) {
                indexList.add(map.get(c));
            } else {
                return null;
            }
        }

        int[] sublistPointer = new int[N];
        int minWindowSize = M + 1;
        int startIndex = -1;
        int endIndex = -1;

        for (sublistPointer[0] = 0; sublistPointer[0] < indexList.get(0).size(); sublistPointer[0]++) {
            for (int sublistIndex = 1; sublistIndex < N; sublistIndex++) {

                while (sublistPointer[sublistIndex] < indexList.get(sublistIndex).size() &&
                        indexList.get(sublistIndex).get(sublistPointer[sublistIndex]) <= indexList.get(sublistIndex - 1).get(sublistPointer[sublistIndex - 1])) {
                    ++sublistPointer[sublistIndex];
                }

                if (sublistPointer[sublistIndex] == indexList.get(sublistIndex).size()) {
                    return (startIndex == -1) ? null : S.substring(startIndex, endIndex + 1);
                }
            }

            int currentStartIndex = indexList.get(0).get(sublistPointer[0]);
            int currentEndIndex = indexList.get(N - 1).get(sublistPointer[N - 1]);
            int windowSize = currentEndIndex - currentStartIndex;

            if (windowSize < minWindowSize) {
                minWindowSize = windowSize;
                startIndex = currentStartIndex;
                endIndex = currentEndIndex;
            }
        }

        return (startIndex == -1) ? null : S.substring(startIndex, endIndex + 1);
    }
}

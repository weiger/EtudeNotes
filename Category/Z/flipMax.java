import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public static void flipBits1(int[] a) {

        int maxDiff = 0;
        int flipStartIndex = 0;
        int flipEndIndex = 0;
        int onesToFlip = 0;
        int totalNumberOfOnes = 0;

        int currentDiff = 0;
        int currentStart = 0;
        int currentOnesToFlip = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                currentDiff -= 1;
            } else {
                currentDiff += 1;
                currentOnesToFlip++;
                totalNumberOfOnes++;
            }
            if (currentDiff < maxDiff) {
                maxDiff = currentDiff;
                flipStartIndex = currentStart;
                flipEndIndex = i;
                onesToFlip = currentOnesToFlip;
            } else if (currentDiff > 0) {
                currentDiff = 0;
                currentStart = i + 1;
                currentOnesToFlip = 0;
            }
        }
        System.out.println(flipEndIndex - flipStartIndex + 1 - onesToFlip +   totalNumberOfOnes - onesToFlip);
    }

    public static void flipBits2(int[] a){
        int cur = 0;
        int max = 0;
        int start = 0;
        int nowstart = 0;
        int end = 0;

        for(int i = 0 ; i < a.length; i++){
            if(a[i] == 0){
                cur++;
                if(cur > max){
                    max = cur;
                    start = nowstart;
                    end = i;
                }
            }else if(a[i] == 1){
                cur--;
                if(cur < 0){
                    cur = 0;
                    nowstart = i + 1;
                }
            }
        }
        if(max == 0) {
            max = a.length;
            System.out.println(max);
            return;
        }
        for(int i = 0 ; i < a.length; i++){
            max += (a[i] == 1) ? 1: 0;
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        int[] data = {1,0,1,0,1,0,1,1,0};
        int[] arr1 = {1,1,0,0,0,1,0,0};
        int[] arr2 = {0,0,0,1,1,1,1,0};
        int[] arr3 = {1,0,0,1,0,0,1,0};
        flipBits1(arr1);
        flipBits2(arr1);

    }
}

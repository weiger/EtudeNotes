import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {

    public int flipMax(int[] arr){
        int countOfOne = 0;
        int maxZero = 0;
        for(int i = 0; i < arr.length; i++){
            int num = 0;
            if(arr[i] == 1){
                countOfOne++;
            }else if(arr[i] == 0){
                int j = 0;
                while(i + j < arr.length && arr[i + j] == 0){
                    j++;
                }
                maxZero = Math.max(maxZero, j);
                i = i + j - 1;
            }
        }
        return maxZero + countOfOne;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,0,0,0,1,0,0};
        int[] arr2 = {0,0,0,1,1,1,1,0};
        System.out.println(new Solution().flipMax(arr1));
        System.out.println(new Solution().flipMax(arr2));
    }
}

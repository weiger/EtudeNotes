import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {

    public static int findPair1(long[] nums,long k){
        HashMap<Long, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                cnt++;
            }

            if(!map.containsKey(nums[i] - k))
                map.put(nums[i] - k, 1);

            if(!map.containsKey(k + nums[i]))
                map.put(nums[i] + k, 1);
        }
        return cnt;
    }

    public static int findPair2(long[] A, int K){
        int count = 0;
        Arrays.sort(A);

        int l = 0;
        int r = 0;
        while(r < A.length)
        {
            if(A[r] - A[l] == K)
            {
                count++;
                l++;
                r++;
            }
            else if(A[r] - A[l] > K)
                l++;
            else // arr[r] - arr[l] < sum
                r++;
        }
        return count;
    }

    public static int findPair3(long[] A, int K){
        Set<Long> set = new HashSet<>();
        int cnt = 0;
        for(int i = 0 ; i < A.length; i++){
            if(set.contains(A[i] - K)){
                cnt++;
            }
            if(set.contains(A[i] + K)){
                cnt++;
            }
            set.add(A[i]);
        }
        return cnt;
    }



    public static void main(String[] args) {
        long[] data = {1 ,2, 3, 4, 5};
        int cnt = findPair2(data, 2);
        System.out.println(cnt);
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public int findPair1(long[] nums,long k){
        HashMap<Long, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                if(!map.containsKey(k - nums[i]))
                    map.put(k - nums[i], 1);
                else
                    map.put(k - nums[i], map.get(k - nums[i]) + 1);
            }else{
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                cnt++;
            }
        }
        return cnt;
    }

    public int findPair2(long[] nums,long k){
        Arrays.sort(nums);
        int cnt = 0;
        int beg = 0; int end = nums.length - 1;
        while(beg < end){
            long sum = nums[beg] + nums[end];
            if(sum == k){
                cnt++;
                beg++;end--;
            }else if(sum > k){
                end--;
            }else if(sum < k){
                beg++;
            }
        }
        return cnt;
    }

    public int findPair3(long[] A, int K){
        Set<Long> set = new HashSet<>();
        Arrays.sort(A);
        int cnt = 0;
        for(int i = 0 ; i < A.length; i++){
            if(set.contains(K - A[i])){
                cnt++;
            }
            if(set.contains(K + A[i])){
                cnt++;
            }
            set.add(A[i]);
        }
        return cnt;
    }

    public static void main(String[] args) {
        long[] arr = {1,0,2,5,8,9,7};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(new Solution().findPair1(arr, 9));
        System.out.println(new Solution().findPair2(arr, 9));
        System.out.println(new Solution().findPair3(arr, 9));
    }
}

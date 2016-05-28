public class Solution {
    public void sortColors(int[] nums) {
        int[] res = new int[3];
        for(Integer e: nums){
            res[e]++;
        }
        int idx = 0;
        for(int i = 0; i < res.length; i++){
            while(res[i] > 0){
                nums[idx++] = i;
                res[i]--;
            }
        }
    }
}

public class Solution {
    public void sortColors(int[] A) {
        int left = 0, right = A.length - 1;
        for(int i = 0; i <= right; i++) {
            if(A[i] == 0)
                swap(A, i, left++);
            else if(A[i] == 2) 
                swap(A, i--, right--);
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

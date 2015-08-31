/*
Implement next permutation, which rearranges numbers into the lexicographically 
next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible 
order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding 
outputs are in the right-hand column.

1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1
 * 
 */
/* 
if 1 2 3 then reverse to 3 2 1 
end 
Ex:  6  8  7  4  3  2   
1:  "6" 8  7  4  3  2    find first num violate descend order, mark it
2:   6   8 "7" 4 3  2    in the rest, find the first num bigger than mark, swap
3.  "7" 8  "6"  4  3  2
4.   7 "2  3  4  6  8"   reverse mark + 1 to end of array, return
*/
public class Solution {
    public void nextPermutation(int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                for(int j = nums.length - 1; j > i; j--){
                    if(nums[j] > nums[i]){
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        reverse(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }
    
    public void reverse(int[] nums, int beg, int end){
        while(beg < end){
            int tmp = nums[beg];
            nums[beg] = nums[end];
            nums[end] = tmp;
            beg++;
            end--;
        }
    }
}

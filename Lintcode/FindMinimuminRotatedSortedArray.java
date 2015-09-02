public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        int beg = 0; int end = num.length - 1;
        while(beg < end){
            int mid = beg + (end - beg) / 2;
            if(num[beg] < num[end]) return num[beg];
            if(num[beg] < num[mid]) beg = mid + 1;
            else if(num[beg] > num[mid]) end = mid;
            else beg++;
        }
        return num[beg];
    }
}

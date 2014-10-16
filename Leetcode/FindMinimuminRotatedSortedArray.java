public class Solution {
    public int findMin(int[] num) {
        if(num==null || num.length==0)
            return -1;
        int beg = 0;
        int end = num.length - 1;
        while(beg<end){
            if(num[beg]<num[end])
                return num[beg];
            int mid = beg + (end - beg) / 2;
            if(num[mid]>=num[beg])
                beg = mid+1;
            else if(num[mid]<num[beg])
                end = mid;
        }
        return num[beg];
    }
}

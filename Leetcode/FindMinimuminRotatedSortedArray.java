/*
1.既然有无序，肯定有无序点
2.如果beg<end那就是有序序列，最小在左边
3.如果beg<mid,前半边为有序，那个无序点肯定后后半边beg=mid+1
4.如果beg>mid,那么无序点在前半部分，mid也有可能是最小值，end = mid
5.如果beg==mid,1.重复元素beg++ 2.只有两个元素且无序 beg++
6.Return beg
(while(beg<end) 可避免很多麻烦)
*/
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
            if(num[beg]<num[mid])
                beg = mid+1;
            else if(num[beg]>num[mid])
                end = mid;
            else
                beg++;
        }
        return num[beg];
    }
}

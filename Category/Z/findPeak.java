public class Solution {
    public int findPeakElement(int[] num) {
        if(num==null || num.length==0)
            return -1;
        if(num.length==1)
            return 0;
        int beg = 0;
        int end = num.length - 1;
        while(beg<=end){
            int mid = beg + (end-beg)/2;
            if(mid==0 || mid == num.length - 1){
                return mid;
            }else if(mid+1<num.length && mid>0 && num[mid]>num[mid+1] && num[mid]>num[mid-1]){
                return mid;
            }else if(mid+1<num.length && mid>0 && num[mid]<num[mid+1] && num[mid]<num[mid-1]){
                return mid;
            }else{
                end = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data1 = {23, 40, 50, 60, 80, 75, 74, 35};
        int[] data2 = {90, 80, 70, 60, 65, 75};
        int res = new Solution().findPeakElement(data1);
        System.out.println(data1[res]);
    }
}

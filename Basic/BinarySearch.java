//Important 1.beg<=end 2. when no target found, end is first element < target , beg is the place to insert
//Example:{1,3,5,7} target = 6 end = 2 beg = 3
public class Solution {

    public static int BinarySearch1(int[] data, int target) {
        int beg = 0;
        int end = data.length - 1;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (data[mid] == target)
                return mid;
            else if (target < data[mid])
                end = mid - 1;
            else
                beg = mid + 1;
        }
        return -1;
    }
    public static int BinarySearch2(int[] data, int target,int beg,int end){
        if(beg>end)
            return -1;
        int mid = beg + (end - beg)/2;
        if(data[mid]==target) return mid;
        else if(data[mid]>target)
            return BinarySearch2(data,target,beg,mid-1);
        else
            return BinarySearch2(data,target,mid+1,end);
    }
    public static void main(String[] args) {
        int[] data = { 1,3,5,7,9};

        System.out.println(BinarySearch1(data,3));
        System.out.println(BinarySearch2(data,3,0,data.length-1));
    }
}

public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (index >= citations[i]) {
                return index;
            }
            index++;
        }
        return index;
    }
}

public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int beg = 0, end = len;
        while(beg < end){
            int mid = beg + (end - beg) / 2;
            if(citations[mid] == len - mid) return len - mid;
            if(citations[mid] < len - mid) beg = mid + 1;
            else end = mid;
        }
        return len - beg;
    }
}

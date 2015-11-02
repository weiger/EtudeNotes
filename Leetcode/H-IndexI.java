public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
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
        int[] count = new int[len + 1];
    
        for (int c: citations)
            if (c > len) 
                count[len]++;
            else 
                count[c]++;
        int total = 0;
        for (int i = len; i >= 0; i--) {
            total += count[i];
            if (total >= i)
                return i;
        }
    
        return 0;
    }
}

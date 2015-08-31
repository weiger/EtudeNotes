public class Solution {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        int len = chars.length;
        if (len <= 1) return;
        int beg = 0, end = len-1;
        while (beg < end){
            while (beg < end && beg < len && chars[beg]>='a' && chars[beg]<='z') beg++;
            while (end >= 0 && beg < end && chars[end]>='A' && chars[end]<='Z') end--;
            char temp = chars[beg];
            chars[beg] = chars[end];
            chars[end] = temp;
        }
    }
}

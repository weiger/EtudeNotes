public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str == null || str.length == 0) return;
        offset = str.length - offset % str.length;
        reverse(str, 0, offset - 1);
        reverse(str, offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }
    
    public void reverse(char[] str, int beg, int end){
        while(beg < end){
            char tmp = str[beg];
            str[beg] = str[end];
            str[end] = tmp;
            beg++; end--;
        }
    }
}

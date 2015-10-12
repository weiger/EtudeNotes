public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int j = 0;
        for(int i = 0 ; i < s.length; i++){
            if(s[i] == ' ' || i == s.length - 1){
                if (i == s.length - 1)
                    reverse(s, j, i);
                else
                    reverse(s, j, i - 1);
                j = i + 1;
            }
        }
    }
    public void reverse(char[] s, int beg, int end){
        while(beg < end){
            char tmp = s[beg];
            s[beg] = s[end];
            s[end] = tmp;
            beg++;
            end--;
        }
    }
}

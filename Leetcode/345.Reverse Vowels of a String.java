public class Solution {
    public String reverseVowels(String s) {
        int beg = 0; int end = s.length() - 1;
        char[] arr = s.toCharArray();
        while (beg < end) {
            if (isVowel(arr[beg]) && isVowel(arr[end])) {
                char tmp = arr[beg];
                arr[beg] = arr[end];
                arr[end] = tmp;
                beg++;
                end--;
            } else if (isVowel(arr[beg])) {
                end--;
            } else if (isVowel(arr[end])) {
                beg++;
            } else {
                beg++;end--;
            }
        }
        return new String(arr);
    }
    public boolean isVowel(char c){
        switch (c) {
            case 'a': case 'A':
            case 'e': case 'E':
            case 'i': case 'I':
            case 'o': case 'O':
            case 'u': case 'U':
                return true;
            default:
                return false;
        }
    }
}
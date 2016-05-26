public class Solution {
    public boolean isStrobogrammatic(String num) {
        int beg = 0;
        int end = num.length() - 1;
        while (beg < end) {
            char a = num.charAt(beg);
            char b = num.charAt(end);
            if (a == '0') {
                if (b != '0') return false;
            } else if (a == '1') {
                if (b != '1') return false;
            } else if (a == '8') {
                if (b != '8') return false;
            } else if (a == '6') {
                if (b != '9') return false;
            } else if (a == '9') {
                if (b != '6') return false;
            } else {
                return false;
            }
            beg++;end--;
        }
        if (num.length() % 2 == 1) {
            char c = num.charAt(beg);
            if (c != '0' && c != '1' && c != '8') return false; 
        }
        return true;
    }
}
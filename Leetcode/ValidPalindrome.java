/*
 * Given a string, determine if it is a palindrome, considering only 
 * alphanumeric characters and ignoring cases.

 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question 
 * to ask during an interview.

 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if(s ==  null || s.length() <= 1){
            return true;
        }
        int beg = 0;
        int end = s.length() - 1;
        while(beg < s.length() && s.charAt(beg) == ' '){
            beg++;
        }
        while(end >= 0 && s.charAt(end) == ' '){
            end--;
        }
        while(beg < end){
            char a = s.charAt(beg);
            char b = s.charAt(end);
            if((a < 'a' || a > 'z') && (a < 'A' || a > 'Z') && (a < '0' || a > '9')){
                beg++;
            }else if((b < 'a' || b > 'z') && (b < 'A' || b > 'Z') && (b < '0' || b > '9')){
                end--;
            }else if(a != b && Math.abs(a - b) != Math.abs('a' - 'A')){
                return false;
            }else{
                beg++;
                end--;
            }
        }
        return true;
    }
}

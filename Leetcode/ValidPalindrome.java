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
                int i = 0;
        int j = s.length()-1;
        while(i<j){
            char a = s.charAt(i);
            char b = s.charAt(j);
            if( (a<'0'||a>'9') && (a<'a'||a>'z') && (a<'A'||a>'Z'))
                i++;
            else if((b<'0'||b>'9') && (b<'a'||b>'z') && (b<'A'||b>'Z'))
                j--;
            else if(a==b || Math.abs(a-b) == 32){
                i++;j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}

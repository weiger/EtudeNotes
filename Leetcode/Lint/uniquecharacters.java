/*
Implement an algorithm to determine if a string has all unique characters
Example
Given "abc", return true
Given "aab", return false
Challenge
What if you can not use additional data structures?
*/

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++){
            if((arr[i] ^ arr[i - 1]) == 0)
                return false;
        }
        return true;
    }
}

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        boolean[] rec = new boolean[255];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(rec[c])
                return false;
            else
                rec[c] = true;

        }
        return true;
    }
}

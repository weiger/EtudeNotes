/*
 * Write a function to find the longest common prefix string amongst an array 
 * of strings.
 */
// Brutal O(n^2)
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) 
            return "";
        int max = strs[0].length();
        for(int i = 1; i<strs.length;i++){
            max = Math.min(max,strs[i].length());
            for(int j=0;j<max;j++){
                if(strs[i].charAt(j)!=strs[0].charAt(j))
                    max = j;
            }
        }
        return strs[0].substring(0,max);
    }
}

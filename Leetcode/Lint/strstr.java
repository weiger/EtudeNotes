/*
strstr (a.k.a find sub string), is a useful function in string operation. You task is to implement this function. 

For a given source string and a target string, you should output the "first" index(from 0) of target string in source string.

If target is not exist in source, just return -1.

Example
If source="source" and target="target", return -1.

If source="abcdabcdefg" and target="bcd", return 1.
*/
class Solution {
    /**
     * Returns a index to the first occurrence of target in source, or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if(source==null || target==null)
            return -1;
        if(source.equals(target) || target.length()==0)
            return 0;
        for(int i=0;i<=source.length()-target.length();i++){
            for(int j=0;j<target.length();j++){
                if(source.charAt(i+j)!=target.charAt(j))
                    break;
                if(j==target.length()-1)
                    return i;
            }
        }
        return -1;
    }
}

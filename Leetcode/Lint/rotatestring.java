*/
Given a string and an offset, rotate string by offset. (rotate from left to right)

Example
Given "abcdefg" and offset=3, return "efgabcd"
*/

public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char [] rotateString(char [] A, int offset) {
        if(A==null || A.length==0)
            return A;
        offset = A.length - offset % A.length;
        reverse(A,0,offset-1);
        reverse(A,offset,A.length-1);
        reverse(A,0,A.length-1);
        return A;
    }
    public void reverse(char[] A,int beg,int end){
        while(beg<end){
            char tmp = A[beg];
            A[beg] = A[end];
            A[end] = tmp;
            beg++;
            end--;
        }
    }
};

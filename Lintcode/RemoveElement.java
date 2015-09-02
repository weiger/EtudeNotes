public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        int index = 0;
        for(int x: A){
            if(x != elem){
                A[index++] = x;
            }
        }
        return index;
    }
}

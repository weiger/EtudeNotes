/*
Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

Example
Given [1,1,2,3,3,3,2,2,4,1] return 4

Challenge
One-pass, constant exstra space
*/

public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        int one = 0;
        int two = 0;
        int three = 0;
        for(int x:A){
            two |= x & one;
            one ^= x;
            three = one & two;
            one = ~three & one;
            two = ~three & two;
        }
        return one;
    }
}

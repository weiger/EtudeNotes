/*
Find the first bad version.
You should call isBadVersion as few as possible. 
Please read the annotation in code area to get the correct way to call isBadVersion in different language. For example, 
Java is VersionControl.isBadVersion.
Example
Given n=5
Call isBadVersion(3), get false
Call isBadVersion(5), get true
Call isBadVersion(4), get true
return 4 is the first bad version
Challenge
Do not call isBadVersion exceed O(logn) times.
*/

/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge wether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int beg = 0;
        int end = n - 1;
        while(beg <= end){
            int mid = beg + (end - beg)/2;
            if(VersionControl.isBadVersion(mid)){
                end = mid - 1;
            }else{
                beg = mid + 1;
            }
        }
        return beg;
    }
}



/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int beg = 1;
        int end = n;
        while(beg <= end){
            int mid = beg + (end - beg) / 2;
            if(VersionControl.isBadVersion(mid)){
                end = mid - 1;
            }else{
                beg = mid + 1;
            }
        }
        return beg;
    }
}

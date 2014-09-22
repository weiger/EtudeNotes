/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 * Your algorithm's runtime complexity must be in the order of O(log n).

 * If the target is not found in the array, return [-1, -1].

 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4]. 
 */
public class Solution {

/*    O(log n)    */
/*first search lower bound if target <= midd , high = mid - 1, if found beg is res[0]
  if not found, beg is out of index or A[beg]!=target
  then search upper bound if target >=, beg = mid + 1, if found end is res[1]
  if not found, end is out of index or A[end]!=target
*/
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        int low = 0, high = A.length - 1, mid = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(A[mid] < target) //< 
                low = mid + 1;
            else                //include =
                high = mid - 1;
        }
        res[0] = (low >= A.length || A[low] != target) ? -1 : low; //be careful

        high = A.length - 1;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(A[mid] > target) // >
                high = mid - 1;
            else                //include =
                low = mid + 1;
        }
        res[1] = (high < 0 || A[high] != target) ? -1 : high; //be careful
        return res;
    }
}
//O(n)

    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
    	int flag = 0;
    	while (flag < A.length && A[flag] != target) {
    	    flag++;
    	}
    	if (flag == A.length) {
    	    res[0] = -1;
    	    res[1] = -1;
    	} else if (flag == A.length - 1) {
    	    res[0] = flag;
    	    res[1] = flag;
    	} else {
    	    res[0] = flag;
    	    while (flag < A.length - 1 && A[flag] == A[flag+1]) {
    		flag++;
    	    }
    	    res[1] = flag;
    	}
    	return res;
    }

/*   O(n)
 *  public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        int start = 0, end = A.length - 1;
        for(; start < A.length - 1 && A[start] != target; start++);
        for(; end >= start && A[end] != target; end--);
        if(start > end) {
            start = -1;
            end = -1;
        }
        res[0] = start;
        res[1] = end;
        return res;
    }
*/

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1); res.add(-1);
        int beg = 0; int end = A.size() - 1;
        while(beg <= end){
            int mid = beg + (end - beg) / 2;
            if(A.get(mid) >= target){
                end = mid - 1;
            }else{
                beg = mid + 1;
            }
        }
        if(beg >= 0 && beg < A.size() && A.get(beg) == target){
            res.set(0, beg);
            end = A.size() - 1;
        }else{
            return res;
        }

        while(beg <= end){
            int mid = beg + (end - beg) / 2;
            if(A.get(mid) <= target){
                beg = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        if(end < A.size() && end >= 0 && A.get(end) == target){
            res.set(1, end);
            return res;
        }
        return res;
    }
}

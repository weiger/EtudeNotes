class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        int m = 0; int n = 0;
        while(m < A.size() && n < B.size()){
            if(A.get(m) <= B.get(n)){
                res.add(A.get(m++));
            }else{
                res.add(B.get(n++));
            }
        }
        while(m < A.size()){
            res.add(A.get(m++));
        }
        while(n < B.size()){
            res.add(B.get(n++));
        }
        return res;
    }
}

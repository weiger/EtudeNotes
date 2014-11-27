/*
Merge two given sorted integer array A and B into a new sorted integer array.

Example
A=[1,2,3,4]

B=[2,4,5,6]

return [1,2,2,3,4,4,5,6]
*/
class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> res = new ArrayList<Integer>(A.size()+B.size());
        int a = 0;
        int b = 0;

        while(a<A.size() && b<B.size()){
            if(A.get(a)<=B.get(b)){
                res.add(A.get(a));
                a++;
            }else{
                res.add(B.get(b));
                b++;
            }
        }
        for(;a<A.size();a++){
            res.add(A.get(a));
        }
        for(;b<B.size();b++){
            res.add(B.get(b));
        }   
        return res;
    }
}


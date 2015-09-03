public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE; int sum = 0;
        int start = 0; int end = 0;
        res.add(start); res.add(end);
        for(int i = 0 ; i < A.length; i++){
            sum += A[i];
            if(sum > max){
                res.set(0, start);
                res.set(1, i);
                max = sum;
            }
            if(sum < 0){
                start = i + 1;
                end = i + 1;
                sum = 0;
            }
        }
        return res;
    }
}

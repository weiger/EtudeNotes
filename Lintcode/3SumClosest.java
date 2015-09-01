public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        Arrays.sort(numbers);
        int res = numbers[0] + numbers[1] + numbers[2];
        for(int i = 0 ; i < numbers.length; i++){
            int beg = i + 1;
            int end = numbers.length - 1;
            while(beg < end){
                int sum = numbers[beg] + numbers[end] + numbers[i];
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if(sum == target){
                    return target;
                }else if(sum < target){
                    beg++;
                }else if(sum > target){
                    end--;
                }
            }
        }
        return res;
    }
}


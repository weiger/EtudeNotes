public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numbers.length - 1; i++){
            int beg = i + 1; int end = numbers.length - 1;
            while(beg < end){
                int sum = numbers[beg] + numbers[end] + numbers[i];
                if(sum == 0){
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[i]);
                    list.add(numbers[beg]);
                    list.add(numbers[end]);
                    res.add(list);
                    while(beg + 1 < numbers.length && numbers[beg] == numbers[beg + 1]){
                        beg++;
                    }
                    while(end - 1 >= 0 && numbers[end] == numbers[end - 1]){
                        end--;
                    }
                    beg++;end--;
                }else if(sum < 0){
                    beg++;
                }else if(sum > 0){
                    end--;
                }
            }
            while(i + 1 < numbers.length && numbers[i] == numbers[i + 1]){
                i++;
            }
        }
        return res;
    }
}

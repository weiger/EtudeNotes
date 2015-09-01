public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
        //write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(numbers);
        for(int i = 0 ; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                int beg = j + 1; int end = numbers.length - 1;
                while(beg < end){
                    int sum = numbers[beg] + numbers[end] + numbers[i] + numbers[j];
                    if(sum == target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
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
                    }else if(sum > target){
                        end--;
                    }else if(sum < target){
                        beg++;
                    }
                }
                while(j + 1 < numbers.length && numbers[j] == numbers[j + 1]){
                    j++;
                }
            }
            while(i + 1 < numbers.length && numbers[i] == numbers[i + 1]){
                i++;
            }
        }
        return res;
    }
}


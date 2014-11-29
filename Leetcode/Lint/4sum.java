/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)

The solution set must not contain duplicate quadruplets.

Example
For example, given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

(-1, 0, 0, 1)

(-2, -1, 1, 2)

(-2, 0, 0, 2)
*/

public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(numbers==null || numbers.length<4)
            return res;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(j>i+1 && numbers[j]==numbers[j-1])
                    continue;
                int k = j + 1;
                int l = numbers.length - 1;
                while(k<l){
                    int sum = numbers[i] + numbers[j] + numbers[k] + numbers[l];
                    if(sum==target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        list.add(numbers[l]);
                        res.add(list);
                        while(k<l && numbers[k]==numbers[k+1]){
                        k++;
                        }
                        while(k<l && numbers[l]==numbers[l-1]){
                            l--;
                        }
                        k++;l--;
                    }else if(sum<target){
                        k++;
                    }else if(sum>target){
                        l--;
                    }
                }
                while(j<numbers.length-1 && numbers[j]==numbers[j+1]){
                    j++;
                }
            }
            while(i<numbers.length-1 && numbers[i]==numbers[i+1]){
                i++;
            }
        }
        return res;
    }
}

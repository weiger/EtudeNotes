public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(numbers==null || numbers.length==0)
            return res;
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length-1;i++){
            int beg = i + 1;
            int end = numbers.length - 1;
            while(beg<end){
                int sum = numbers[i] + numbers[beg] + numbers[end];
                if(sum<0){
                    beg++;
                }else if(sum>0){
                    end--;
                }else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[beg]);
                    list.add(numbers[end]);
                    res.add(list);
                    while(beg<end && numbers[beg]==numbers[beg+1]){
                        beg++;
                    }
                    beg++;
                    while(beg<end && numbers[end]==numbers[end-1]){
                        end--;
                    }
                    end--;
                }
            }
            while(i<numbers.length-1 && numbers[i]==numbers[i+1]){
                i++;
            }
        }
        return res;
    }
}

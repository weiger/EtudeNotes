public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if(num == null || num.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int val: num){
            set.add(val);
        }
        int max = 1;
        for(int i = 0; i < num.length; i++){
            int cur = count(set, num[i], false) + count(set, num[i] + 1, true);
            max = Math.max(max, cur);
        }
        return max;
    }

    public int count(HashSet<Integer> set, int val, boolean asc){
        int cnt = 0;
        while(set.contains(val)){
            cnt++;
            set.remove(val);
            if(asc){
                val = val + 1;
            }else{
                val = val - 1;
            }
        }
        return cnt;
    }
}

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		if(nums.size() <= 1){
		    return nums;
		}
		int i = nums.size() - 2;
		for(; i >= 0; i--){
		    if(nums.get(i) > nums.get(i + 1)){
		        break;
		    }else if(i == 0){
		        reverse(nums, 0, nums.size() - 1);
		        return nums;
		    }
		}
		int j = nums.size() - 1;
		for(; j > i; j--){
		    if(nums.get(j) < nums.get(i)){
		        break;
		    }
		}
		int tmp = nums.get(i);
		nums.set(i, nums.get(j));
		nums.set(j, tmp);
		reverse(nums, i + 1, nums.size() - 1);
		return nums;
    }
    
    public void reverse(ArrayList<Integer> nums, int beg, int end){
        while(beg < end){
            int tmp = nums.get(beg);
            nums.set(beg, nums.get(end));
            nums.set(end, tmp);
            beg++; end--;
        }
    }
}

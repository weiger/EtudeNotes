/*
 * Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

 * Note:

 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b 
 * <= c)
 * The solution set must not contain duplicate triplets.
 *   For example, given array S = {-1 0 1 2 -1 -4},

 *   A solution set is:
 *   (-1, 0, 1)
 *   (-1, -1, 2)
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        for(int i = 0;i<num.length-2;i++){
            if(i>0 && num[i]==num[i-1])
                continue;
            int left = i+1;
            int right = num.length - 1;
            while(left<right){
                int sum = num[left] + num[right]+num[i];
                if(sum>0)
                    right--;
                else if(sum<0)
                    left++;
                else{
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);list.add(num[left]);list.add(num[right]);
                    res.add(list);
                    do{
                        left++;
                    }while(left<right&&num[left]==num[left-1]);
                    do{
                        right--;
                    }while(right>left&&num[right]==num[right+1]);
                }
            }
        }
        return res;
    }
}
//From 2Sum to 3Sum
public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	if (num == null || num.length < 3)
	    return res;
	Arrays.sort(num);
	for (int i = num.length - 1; i >= 2; i--) {
	    if (i < num.length - 1 && num[i] == num[i + 1])
		continue;
	    ArrayList<ArrayList<Integer>> cur = twoSum(num, i - 1, -num[i]);
	    for (int j = 0; j < cur.size(); j++)
		cur.get(j).add(num[i]);
	    res.addAll(cur);
	}
	return res;
    }

    private static ArrayList<ArrayList<Integer>> twoSum(int[] num, int end,
	    int target) {
	Arrays.sort(num);
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	if (num.length < 2 || num == null)
	    return res;
	int i = 0, j = end, sum = 0;
	while (i < j) {
	    sum = num[i] + num[j];

	    if (sum < target)
		i++;
	    else if (sum > target)
		j--;
	    else  {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(num[i]);
		list.add(num[j]);
		res.add(list);
		i++;
		j--;
		while (num[i] == num[i - 1] && i < j)
		    i++;
		while (num[j] == num[j + 1] && i < j)
		    j--;
	    }
	}
	return res;
    }

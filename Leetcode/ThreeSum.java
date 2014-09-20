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
import java.util.*;

public class ThreeSum {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i <= num.length - 2 && num[i] <= 0; i++) { //or i<num.length - 1
            if (i > 0 && num[i] == num[i - 1])
                continue;
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                if (num[i] + num[j] + num[k] > 0) {
                    k--;
                } else if (num[i] + num[j] + num[k] < 0) {
                    j++;
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    res.add(list);
                    do {
                        j++;
                    } while (j < k && num[j] == num[j - 1]);
                    do {
                        k--;
                    } while (j < k && num[k] == num[k + 1]);
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

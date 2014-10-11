/*Given a set S, find all the maximal subsets whose sum <= k. For example, 
 * if S = {1, 2, 3, 4, 5} and k = 7

Output is: {1, 2, 3} {1, 2, 4} {1, 5} {2, 5} {3, 4}

Hint:

- Output doesn’t contain any set which is a subset of other.

- If X = {1, 2, 3} is one of the solution then all 
the subsets of X {1} {2} {3} {1, 2} {1, 3} {2, 3} are omitted.

- Lexicographic ordering may be used to solve it
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> closestSubset(int[] S, int k) {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<>();
	Arrays.sort(S);
	int[] sum = new int[1];
	sum[0] = 0;
	helper(res, list, S, k, 0, sum);
	post(res);
	return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list,
	    int[] S, int k, int pos, int[] sum) {
	
	    if (pos < S.length) {
		if (sum[0] + S[pos] > k) {
		    res.add(new ArrayList<>(list));
		    return;}
	    } else if (pos == S.length && sum[0] <= k) {
		res.add(new ArrayList<>(list));
		return;
	    }
	    for (int i = pos; i < S.length; i++) {
		list.add(S[i]);
		sum[0] += S[i];
		helper(res, list, S, k, i + 1, sum);
		sum[0] -= S[i];
		list.remove(list.size() - 1);
	    }
	}
    
    public static void post(List<List<Integer>> res){
	for(int i=0;i<res.size()-1;i++)
	    for(int j=i+1;j<res.size();j++)
		if(res.get(i).containsAll(res.get(j))){
		    res.remove(res.get(j));
		}
    }

    public static void main(String[] args) {
	int[] S = { 1, 2, 3, 4, 5 };
	System.out.println(closestSubset(S, 7)); 
    }
}

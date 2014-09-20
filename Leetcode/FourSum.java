/*
 * Given an array S of n integers, are there elements a, b, c, and d in S such 
 * that a + b + c + d = target? Find all unique quadruplets in the array which 
 * gives the sum of target.

 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, 
 * a <= b <= c <= d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 * 
 */

public class FourSum {
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            for (int j = i + 1; j < num.length; j++) {
                if (j > i + 1 && num[j] == num[j - 1])
                    continue;
                int k = j + 1;
                int p = num.length - 1;
                while (k < p) {
                    int sum = num[i] + num[j] + num[k] + num[p];
                    if (sum > target) 
                        p--;
                    else if (sum < target)
                        k++;
                    else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[k]);
                        list.add(num[p]);
                        res.add(list);
                        do {
                            k++;
                        } while (k < p && num[k] == num[k - 1]);
                        do {
                            p--;
                        } while (k < p && num[p] == num[p + 1]);
                    }
                }
            }
        }
        return res;
    }

}
//2-3-4 sum
public class ThreeSum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	if(num==null || num.length<4)
	    return res;
	Arrays.sort(num);
	for(int i=num.length-1;i>2;i--){
	    if(i==num.length-1 || num[i]!=num[i+1]){
		ArrayList<ArrayList<Integer>> cur = threeSum(num,i-1,target-num[i]);
		for(int j=0;j<cur.size();j++){
		    cur.get(j).add(num[i]);
		}
		res.addAll(cur);
	    } 
	}
	return res;
    }
    
    private static ArrayList<ArrayList<Integer>> threeSum(int[] num, int end, int target)  
    {  
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
        for(int i=end;i>1;i--)  
        {  
            if(i==end || num[i]!=num[i+1])  
            {  
                ArrayList<ArrayList<Integer>> curRes = twoSum(num,i-1,target-num[i]);  
                for(int j=0;j<curRes.size();j++)  
                {  
                    curRes.get(j).add(num[i]);  
                }  
                res.addAll(curRes);  
            }  
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

}
//DFS Time Limit Exceed
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Arrays.sort(num);
    	boolean[] isv = new boolean[num.length];
    	int sum = 0;
    	helper(res, list, num,isv, target, 0, 0);
    	return res;
    }
    public static void helper(ArrayList<ArrayList<Integer>> res,
	    ArrayList<Integer> list, int[] num, boolean[] isv, int target,
	    int m, int k) {
    	if (k == 4 && target==0) {
    	    res.add(new ArrayList<Integer>(list));
    	}
    	for (int i = m; i < num.length; i++) {
    	    if (isv[i] == false) {
    		isv[i] = true;
    		list.add(num[i]);
    		helper(res, list, num, isv, target - num[i],i, k + 1);
    		isv[i] = false;
    		list.remove(list.size() - 1);
    		while (i < num.length - 1 && num[i] == num[i + 1]) {
    		    i++;
    		}
    	    }
    
    	}
    }
}
//
public class Solution {
	public static ArrayList<ArrayList<Integer>> fourSum1(int[] num, int target) {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list = new ArrayList<Integer>();
	Arrays.sort(num);
	boolean[] isv = new boolean[num.length];
	int sum = 0;
	helper(res, list, num, isv, target, 0, 0);
	return res;
    }

    public static void helper(ArrayList<ArrayList<Integer>> res,
	    ArrayList<Integer> list, int[] num, boolean[] isv, int target,
	    int m, int k) {
	if (k == 3) {
	    int a = m;
	    int b = num.length - 1;
	    while (a <= b) {
		int mid = (a + b) / 2;
		if (target < num[mid])
		    b = mid - 1;
		else if (target > num[mid])
		    a = mid + 1;
		else {
		    list.add(num[mid]);
		    res.add(new ArrayList<Integer>(list));
		    list.remove(list.size() - 1);
		    return;
		}
	    }
	    return;
	}
	for (int i = m; i < num.length; i++) {
	    if (isv[i] == false) {
		isv[i] = true;
		list.add(num[i]);
		helper(res, list, num, isv, target - num[i], i, k + 1);
		isv[i] = false;
		list.remove(list.size() - 1);
		while (i < num.length - 1 && num[i] == num[i + 1]) {
		    i++;
		}
	    }
	}
	
    }
}
//n3
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(num==null || num.length<4) return res;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	Arrays.sort(num);
    	boolean[] isv = new boolean[num.length];
    	int sum = 0;
    	helper(res, list, num, isv, target, 0, 0);
    	return res;
    }
    
    public static void helper(ArrayList<ArrayList<Integer>> res,
	    ArrayList<Integer> list, int[] num, boolean[] isv, int target,
	    int m, int k) {
	    if (k == 2) {
	    int a = m+1;
	    int b = num.length - 1;
	    while(a<b){
		int sum = num[a]+num[b];
		if(sum>target)
			b--;
		    else if(sum<target)
			a++;
		    else if(sum==target)
		    {
			list.add(num[a]);
			list.add(num[b]);
			res.add(new ArrayList<Integer>(list));
			list.remove(list.size()-1);
			list.remove(list.size()-1);
			a++;b--;
			while (num[a] == num[a - 1] && a < b)
			    a++;
			while (num[b] == num[b + 1] && a < b)
			    b--;
		    }
	    }
	    return;
	}
	
	for (int i = m; i < num.length; i++) {
	    if (isv[i] == false) {
		isv[i] = true;
		list.add(num[i]);
		helper(res, list, num, isv, target - num[i], i, k + 1);
		isv[i] = false;
		list.remove(list.size() - 1);
		while (i < num.length - 1 && num[i] == num[i + 1]) {
		    i++;
		}
	    }
	}

    }
}

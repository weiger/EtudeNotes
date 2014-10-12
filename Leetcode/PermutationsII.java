/*
 * Given a collection of numbers, return all possible permutations.

 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if(num==null || num.length==0)
            return res;
        Arrays.sort(num);
        List<Integer> list = new ArrayList<>();
        boolean[] rec = new boolean[num.length];
        helper(res,list,rec,num,0);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> list,boolean[] rec,int[] num,int deep){
        if(deep==num.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<num.length;i++){
            if(!rec[i]){
                list.add(num[i]);
                rec[i] = true;
                helper(res,list,rec,num,deep+1);
                rec[i] = false;
                list.remove(list.size()-1);
                while(i<num.length-1 && num[i]==num[i+1]){
                    i++;
                }
            }
        }
    }
}


public class PermutationsII {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
		for(int i = 0; i < num.length; i++) {
			HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
			for(int j = 0; j < res.size(); j++) {
				for(int k = 0; k <= res.get(j).size(); k++) {
					ArrayList<Integer> list = new ArrayList<Integer>(res.get(j));
					list.add(k, num[i]);
					set.add(list);
				}
			}
			res = new ArrayList<ArrayList<Integer>>(set);
		}
		return res;
    }
}


/*
 * Given two integers n and k, return all possible combinations of k numbers out 
 * of 1 ... n.

 * For example,
 * If n = 4 and k = 2, a solution is:

 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
 /*
   1 [2..4] = [1,2][1,3][1,4]
   2 [3..4] = [2,3][2,4]
   3 [4..4] = [3,4]
 */
 public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(res,list,n,k,1);
        return res;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,int n,int k,int pos){
        if(k==0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = pos;i<=n;i++){
            if(!list.contains(i)){
                list.add(i);
                dfs(res,list,n,k-1,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
/*back to search
  combine(4,2) - 4->combine(3,1) ->1,2,3 = [4,1] [4,2] [4,3]
                 3->combine(2,1)->1,2 = [3,1] [3,2]
                 2->combine(1,1)->1 = [2,1]
*/
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(k == 1) {
            for(int i = 1; i <= n; i++) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(i);
                res.add(list);
            }
            return res;
        }
        for(int i = n; i >= k; i--) {
            for(ArrayList<Integer> list : combine(i - 1, k - 1)) {
                list.add(i);
                res.add(list);
            }
        }
        return res;
    }
}

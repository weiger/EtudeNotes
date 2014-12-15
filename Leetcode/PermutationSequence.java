/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):

 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.

 * Note: Given n will be between 1 and 9 inclusive.
 */

public class PermutationSequence {

/**************************** updated 2014.03.12 *****************************/

   public String getPermutation(int n, int k) {
        String res = "";
        String s = "";
        int factor = 1;
        for (int i = 1; i <= n; i++) {
            s += i;
            factor *= i;
        }
        k--;
        while (n > 0) {
            factor /= n;
            res += s.charAt(k / factor);
            s = s.substring(0, k / factor) + s.substring(k / factor + 1);
            k %= factor;
            n--;
        }
        return res;
    } 
}
/************************************************************************/
//Time Limit Exceeded
public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(res,list,n,"");
        return res.get(k-1);
    }
    public void helper(ArrayList<String> res,ArrayList<Integer> list,int n,String str){
        if(list.size()==n){
            res.add(str);
            return;
        }
        for(int i=1;i<=n;i++){
            if(!list.contains(i)){
                list.add(i);
                helper(res,list,n,str+i);
                list.remove(list.size()-1);
            }
        }
    }
}

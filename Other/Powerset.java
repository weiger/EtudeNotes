/*
Print all factors of the product of a given list of distinct primes.
input: 2 3 7   output: factors of 2*3*7:  1 2 3 6 7 14 21 42
according to the amounts of the input; 
*/
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> powerset(List<Integer> primes){
	List<Integer> res = new ArrayList<>();
	helper(res,primes,0,1);
	return res;
    }
    public void helper(List<Integer> res,List<Integer> primes,int deep,int buffer){
	if(deep==primes.size()){
	    res.add(buffer);
	    return;
	}
	helper(res,primes,deep+1,buffer);
	helper(res,primes,deep+1,buffer*primes.get(deep));
    }
    public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<Integer>();
	list.add(2);
	list.add(3);
	list.add(7);
	List<Integer> res = new Solution().powerset(list);
	System.out.println(res);

    }

}

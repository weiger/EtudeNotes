/*
Print all factors of a given int:
e.g. input : 20   output: 1 2 4 5 10 20
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> allfactor(int N) {
	List<Integer> res = new ArrayList<>();
	int curupper = N;
	res.add(1);
	if(N==1)
	    return res;
	res.add(N);
	for (int i = 2; i <curupper; i++) {
	    if (N % i == 0) {
		res.add(i);
		curupper = N / i;
		if (curupper != i)
		    res.add(curupper);
	    }
	}
	return res;
    }

    public static void main(String[] args) {
	List<Integer> res = new Solution().allfactor(20);
	System.out.println(res);
    }
}

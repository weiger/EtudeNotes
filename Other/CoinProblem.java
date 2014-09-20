/*
题目详情为：有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
*/
public class Solution {
    public static int minCoin(int N, int[] options) {
	int[] res = new int[N + 1];
	res[0] = 0;
	for (int i = 1; i <= N; i++) {
	    int min = Integer.MAX_VALUE;
	    for (int j = 0; j < options.length && i >= options[j]; j++) {
			if (i >= options[j])
		    	min = Math.min(min, res[i - options[j]] + 1);
	    	}
	    res[i] = min;
		}
		return res[N];
    }

    public static void main(String[] args) {
		int[] options = { 1, 3, 5 };
		int res = minCoin(10, options);
		System.out.println(res);
    }

}

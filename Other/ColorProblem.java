/*题目：输入是一个数n，代表有n个点，每个点可以染成黑色或者白色，
同一种颜色最多相邻出现2次（即不能黑，黑，黑，因为黑紧接着出现了两次，这种情况下第三个必须是白色）。求有多少种染法。
*/
public class Solution {
    public int colorQuestion(int n) {
      	if (n <= 0)
      	    return 0;
      	if (n == 1)
      	    return 2;
      	int[] same = new int[n + 1];
      	int[] diff = new int[n + 1];
      	same[2] = 2;
      	diff[2] = 2;

  	for (int i = 3; i <= n; i++) {
  	    same[i] = diff[i - 1];
  	    diff[i] = same[i - 1] + diff[i - 1];
  	}
	return same[n] + diff[n];
    }

    public static void main(String[] args) {
	      System.out.println(new Solution().colorQuestion(3));

    }

}

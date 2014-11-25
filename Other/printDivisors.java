//http://www.careercup.com/question?id=12457661


public class Solution {
    public void printDivisors(int n) {
    	System.out.print("1*" + n + "  ");
    	printDivisors("", 1, n);
    }

    public void printDivisors(String prefix, int prev, int n) {
	if (n < 2)
	    return;
	int s = (int) Math.ceil(Math.sqrt(n));
	for (int i = 2; i <= s; i++) {
	    if (n % i == 0) {
		if (i >= prev && n / i >= i) {
		    System.out.print(prefix + i + "*" + n / i + "  ");
		    printDivisors(prefix + i + "*", i, n / i);
		        }
	        }
	    }
    }

    public static void main(String[] args) {
	    new Solution().printDivisors(24);
    }
}

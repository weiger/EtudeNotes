/*A Fibonacci sequence is calculated by adding the previous two members of the sequence, with
the first two members being both 1.
f (1) = 1, f (2) = 1, f (n > 2) = f (n − 1) + f (n − 2)
Your task is to take a number as input, and print that fibonacci number.
Given: 100
Output Should be: 354224848179261915075*/

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static BigInteger generate(int n) {
      	BigInteger[] res = new BigInteger[100];
      	BigInteger a = BigInteger.valueOf(1);
      	BigInteger b = BigInteger.valueOf(1);
      	BigInteger c = BigInteger.valueOf(0);
      	for (int i = 0; i < n - 2; i++) {
      	    c = a.add(b);
      	    a = b;
      	    b = c;
      	}
      	return c;
    }

    public static void main(String[] args) {
      	Scanner sc = new Scanner(System.in);
      	int n=0;
      	if (sc.hasNext()) {
      	    n = sc.nextInt();
      	}
      	System.out.println(generate(n));
    }
}

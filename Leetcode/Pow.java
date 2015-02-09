/*
 * Implement pow(x, n).
 */
public class Solution {
    public double pow(double x, int n) {
        if(n<0) return 1/helper(x,-n);
        else return helper(x,n);
    }
    public double helper(double x,int n){
        if(n==0)
            return 1;
        double half = helper(x,n/2);
        if(n%2==0)
            return half * half;
        else
            return x * half * half;
    }
}
/* For Practice */
public class pow
{
	public static double pow(double x, int n)
	{
		if (n < 0)
		{
			return 1 / helper4(x, -n);
		} else
			return helper4(x, n);
	}
	
	
	public static double helper1(double x, int n)
	{
		double res = 1;;
		for (int i = 1; i <= n; i++)
		{
			res = res * x;
		}
		return res;
	}
	public static double helper2(double x, int n)
	{
		if (n == 0)
			return 1;
		double temp = helper2(x, n / 2);
		if (n % 2 == 0)
			return temp * temp;
		else
			return x * temp * temp;
	}
	public static double helper3(double x, int n)
	{
		if (n == 0)
			return 1;
		if (n == 1)
			return x;
		double res = 1;
		while (n != 0)
		{
			if (n == 1)
				break;
			if (n % 2 == 1)
			{
				res = res * x;
				x = x * x;
				n = n / 2;
			}
			if (n % 2 == 0)
			{
				x = x * x;
				n = n / 2;
			}
		}
		return res * x;
	}
	public static double helper4(double x, int n)
	{
		if (n == 0)
			return 1;
		else if (n == 1)
			return x;
		else
		{
			while ((n & 1) != 1)
			{
				n >>= 1;
				x *= x;
			}
			if ((n & 1) == 1)
			{
				n >>= 1;
				return x * helper4(x * x, n);
			} else
			{
				n >>= 1;
				return helper4(x * x, n);
			}
		}
	}
	public static void main(String[] args)
	{
		System.out.println(helper1(2,18));
		System.out.println(helper2(2,18));
		System.out.println(helper3(2,18));
		System.out.println(helper4(2,18));
	}
}

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

 * If you were only permitted to complete at most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 */
 public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0 || prices==null)
            return 0;
        int max = 0;
        int min = prices[0];
        int res = 0;
        for(int i=1;i<prices.length;i++){
            res = Math.max(res,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return res;
    }
}
 
 
 
public class BestTimeToBuyAndSellStock {
/******************************** updated 2013/11/20 *****************************/
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if(N == 0)
            return 0;
        int[] leftMin = new int[N], rightMax = new int[N];
        leftMin[0] = prices[0];
        rightMax[N - 1] = prices[N - 1];
        for(int i = 1; i < N; i++) {
            leftMin[i] = Math.min(prices[i], leftMin[i - 1]);
            rightMax[N - 1 - i] = Math.max(prices[N - 1 - i], rightMax[N - i]);
        }
        int res = 0;
        for(int i = 0; i < N; i++) 
            res = Math.max(res, rightMax[i] - leftMin[i]);
        return res;
    } 

/********************************************************************************/

    public int maxProfit(int[] prices) {
        int res = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
/********************************************************************************/
    public static int maxProfit(int[] prices) {
		if(prices.length<2) return 0;
		int min=Integer.MAX_VALUE;int max = Integer.MIN_VALUE;
		for(int i=0;i<prices.length;i++){
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i]-min);
		}
		return max;
    }

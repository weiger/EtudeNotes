/*
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
*/
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int res = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int x:prices){
            min = Math.min(min,x);
            res = Math.max(res,x - min);
        }
        return res;
    }
}

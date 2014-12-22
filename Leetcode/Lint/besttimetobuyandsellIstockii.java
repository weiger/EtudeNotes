/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.
*/
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int len = prices.length;
        int min = prices[0];
        int max = prices[len - 1];
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i = 1;i < len;i++){
            left[i] = Math.max(left[i-1],prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        for(int i = len - 2;i>=0;i--){
            right[i] = Math.max(right[i+1],max - prices[i]);
            max = Math.max(max,prices[i]);
        }
        int res = 0;
        for(int i = 0;i < len;i++){
            res = Math.max(res,left[i]+right[i]);
        }
        return res;
    }
};

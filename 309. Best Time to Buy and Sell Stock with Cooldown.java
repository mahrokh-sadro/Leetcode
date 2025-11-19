// You are given an array prices where prices[i] is the price
// of a given stock on the ith day.

// Find the maximum profit you can achieve. You may complete
// as many transactions as you like (i.e., buy one and sell
// one share of the stock multiple times) with the following restrictions:

//     After you sell your stock, you cannot buy stock on
//     the next day (i.e., cooldown one day).

// Note: You may not engage in multiple transactions 
// simultaneously (i.e., you must sell the stock before you buy again).

class Solution {
    public int maxProfit(int[] prices) {
        int sell=0;
        int pre_sell=0;
        int buy=Integer.MIN_VALUE;
        int pre_buy=0;

        for(int price:prices){
            pre_buy=buy;
            buy=Math.max(pre_sell-price,pre_buy);
            pre_sell=sell;
            sell=Math.max(pre_buy+price,pre_sell);
        }
        
        return sell;
    }
}
//121. Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(minPrice>prices[i]){
                minPrice=prices[i];
            }
            maxProfit=Math.max(maxProfit, prices[i]-minPrice);
        }

        return maxProfit;
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        // 2 ptrs
        // strat:
        // loop throgugh prices
        // set initial price to first indice val, reeval minPrice, 
        // track profit, compare to maxprofit, return maxprofit

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);

            int profit = prices[i] - minPrice;

            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
        
    }
}

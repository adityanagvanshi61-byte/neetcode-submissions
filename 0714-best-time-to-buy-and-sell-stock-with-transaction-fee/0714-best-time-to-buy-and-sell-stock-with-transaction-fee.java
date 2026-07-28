class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int profit =0;
        int buy=prices[0];
        for(int i=0;i<n;i++){
            profit=Math.max(profit,prices[i]-buy-fee);
            buy=Math.min(buy,prices[i]-profit);
        }
        return profit;
    }
}
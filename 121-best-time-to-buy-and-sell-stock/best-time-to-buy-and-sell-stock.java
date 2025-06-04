class Solution {
    public int maxProfit(int[] prices) {
        int small=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<small)
                small=prices[i];
            else if(prices[i]-small>profit)
                profit=prices[i]-small;
        }
        return profit;
    }
}
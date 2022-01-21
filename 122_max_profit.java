class Solution {
    public int maxProfit(int[] prices) {
        int prev = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - prev;
                prev = prices[i];
            }
        }
        profit += prices[prices.length - 1] - prev;
        return profit;
    }
}

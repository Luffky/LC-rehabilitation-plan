class Solution {
    public int maxProfit(int[] prices) {
        int[] minOneProfit = new int[prices.length];
        int min = prices[0];
        for (int i = 1; i < minOneProfit.length; i++) {
            minOneProfit[i] = Math.max(minOneProfit[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        int max = minOneProfit[prices.length - 1];
        int arr = prices[0];
        for (int i = 1; i < minOneProfit.length - 1; i++) {
            if (minOneProfit[i] - prices[i] >= minOneProfit[i - 1] - arr) {
                arr = prices[i];
            } else {
                minOneProfit[i] = minOneProfit[i - 1];
            }
            max = Math.max(max, prices[i + 1] - arr + minOneProfit[i]);
        }
        return max;
    }
}

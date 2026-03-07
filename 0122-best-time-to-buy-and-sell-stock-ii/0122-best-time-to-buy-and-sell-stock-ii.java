class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int profit = 0;
        boolean holding = false;

        for (int i = 0; i < prices.length - 1; i++) {
            if (!holding) {
                if (prices[i] < prices[i + 1]) {
                    buy = prices[i];
                    holding = true;
                }
            } else {
                if (prices[i] > prices[i + 1]) {
                    profit += prices[i] - buy;
                    holding = false;
                }
            }
        }

        if (holding) {
            profit += prices[prices.length - 1] - buy;
        }

        return profit;
    }
}
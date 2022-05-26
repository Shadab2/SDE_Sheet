package DAY1;

// tags : Greedy , Implementation , Easy
public class best_time_to_buy_and_sell_stock_1 {
    // try to buy on the lowest and sell at the highest
    public int maxProfit(int[] prices) {
        int minR = prices[0], maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minR);
            minR = Math.min(minR, prices[i]);
        }
        return maxProfit;
    }
}

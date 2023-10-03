package solution;

public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy_idx = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[buy_idx]) {
                buy_idx = i;
            } else {
                profit = Math.max(profit, prices[i] - prices[buy_idx]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println("121. Best Time to Buy and Sell Stock");
    }
}

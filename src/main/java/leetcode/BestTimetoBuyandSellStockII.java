package leetcode;

/**
 * Created by Jacob on 2014/7/24.
 */
public class BestTimetoBuyandSellStockII {


    public static void main(String[] args) {
        int[] prices = {30, 60, 30, 70, 80, 50};
        BestTimetoBuyandSellStockII solution = new BestTimetoBuyandSellStockII();
        System.out.println(solution.maxProfit(prices));
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p/>
     * Design an algorithm to find the maximum profit.
     * You may complete as many transactions as you like
     * (ie, buy one and sell one share of the stock multiple times).
     * However, you may not engage in multiple transactions at the same time
     * (ie, you must sell the stock before you buy again).
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }

        }
        return profit;

    }
}

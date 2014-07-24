package leetcode;

/**
 * Created by Jacob on 2014/7/24.
 */
public class BestTimetoBuyandSellStockIII {


    public static void main(String[] args) {
        int[] prices = {1, 2};
        BestTimetoBuyandSellStockIII solution = new BestTimetoBuyandSellStockIII();
        System.out.println(solution.maxProfit(prices));
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p/>
     * Design an algorithm to find the maximum profit. You may complete at most two transactions.
     * <p/>
     * Note:
     * You may not engage in multiple transactions at the same time
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

        int[] array1 = new int[prices.length];
        int[] array2 = new int[prices.length + 1];

        int min = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < prices[min]) {
                min = i;
            }

            int temp = prices[i] - prices[min];
            if (temp > maxProfit) {
                maxProfit = temp;
            }
            array1[i] = maxProfit;

        }

        int max = prices.length - 1;
        maxProfit = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] > prices[max]) {
                max = i;
            }

            int temp = prices[max] - prices[i];

            if (temp > maxProfit) {
                maxProfit = temp;
            }
            array2[i] = maxProfit;

        }

        for (int i = 0; i < array1.length; i++) {
            int temp = array1[i] + array2[i + 1];
            if (profit < temp) {
                profit = temp;
            }
        }

        return profit;

    }
}

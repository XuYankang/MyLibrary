package leetcode;

/**
 * Created by Jacob on 2014/7/24.
 */
public class BestTimetoBuyandSellStock {


    public static void main(String[] args) {
        int[] prices = {60, 30, 70, 80, 50};
        BestTimetoBuyandSellStock solution = new BestTimetoBuyandSellStock();
        System.out.println(solution.maxProfit(prices));
    }

    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p/>
     * If you were only permitted to complete at most one transaction
     * (ie, buy one and sell one share of the stock),
     * design an algorithm to find the maximum profit.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = 0;
        int max = 0;


        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < prices[min]) {
                min = i;
            }

            int temp = prices[i] - prices[min];

            if (temp > max) {
                max = temp;
            }

        }
        return max;

    }
}

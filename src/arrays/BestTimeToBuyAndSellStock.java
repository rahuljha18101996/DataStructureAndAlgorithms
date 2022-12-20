package arrays;

/*
* Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
* Solution Explanation : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/solutions/1735493/java-c-best-ever-explanation-could-possible/
* */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int value = Integer.MAX_VALUE;
        for (int price : prices) {
            if (value > price) value = price;
            if ((price - value) > profit) profit = price - value;
        }
        return profit;
    }
}

/*
* [7,1,5,3,6,4]
*
* */

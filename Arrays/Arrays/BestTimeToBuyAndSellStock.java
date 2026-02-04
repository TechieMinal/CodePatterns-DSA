// Problem: Best Time to Buy and Sell Stock (LeetCode 121)
// Approach: One-pass greedy with minimum price tracking
// Pattern: Sliding window + Greedy

/*
Important idea behind this approach:

1. We scan the array only once from left to right.
2. At every step, we maintain the minimum price seen so far (best day to buy).
3. For the current day, we assume we are selling today and compute:
      profit = prices[i] - minPrice.
4. If this profit is better than our previous best, we update maxProfit.
5. This avoids nested loops and gives an optimal O(n) solution.


Code -    */
    
class Solution{
    public static int maxProfit(int[] prices) {

        int bestBuy = Integer.MAX_VALUE;   // minimum price seen so far
        int bestProfit = 0;                // maximum profit so far

        for (int i = 0; i < prices.length; i++) {

            // Update best buying price
            if (prices[i] < bestBuy) {
                bestBuy = prices[i];
            }
            // Otherwise, try selling today
            else {
                int todayProfit = prices[i] - bestBuy;
                bestProfit = Math.max(bestProfit, todayProfit);
            }
        }
        return bestProfit;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

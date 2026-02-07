// Problem: Maximum Subarray (LeetCode 53)
// Approach: Kadane’s Algorithm (one-pass greedy)
// Pattern: Dynamic Programming on prefix / subarray

/*
Important idea behind this approach:

1. We keep a running sum of the current subarray.
2. At every step, we extend the subarray by adding nums[i].
3. If the sum becomes negative, it is useless for future subarrays,
   so we reset sum = 0.
4. We keep updating the maximum sum seen so far.
5. This gives an optimal O(n) time solution.
*/

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        long maxi = Long.MIN_VALUE; // to handle very small values safely
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum = sum + nums[i];

            // Update maximum sum found so far
            if (sum > maxi) {
                maxi = sum;
            }

            // If sum becomes negative, reset it
            if (sum < 0) {
                sum = 0;
            }
        }

        return (int) maxi;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

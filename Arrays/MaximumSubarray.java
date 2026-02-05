// Problem: Maximum Subarray (LeetCode 53)
// Approach: Kadane’s Algorithm (one pass greedy)
// Pattern: Dynamic Programming on prefix / subarray

/*
Important idea behind this approach:

1. At every index, decide whether to:
   - start a new subarray at this element, OR
   - extend the previous subarray.
2. We keep:
   - currentSum → best sum ending at current index
   - maxSum → best sum seen overall
3. If currentSum becomes negative, it is better to restart from the current element.
4. This gives an optimal O(n) solution in a single traversal.
*/

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Either start fresh from nums[i] or extend previous subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update global maximum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums)); // Output: 6
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

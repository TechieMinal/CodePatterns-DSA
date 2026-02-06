// Problem: Product of Array Except Self (LeetCode 238)
// Approach: Precompute left and right products
// Pattern: Prefix / Suffix product

/*
Important idea behind this approach:

1. Build a 'left' array where left[i] = product of all elements before i.
2. Build a 'right' array where right[i] = product of all elements after i.
3. Final answer at index i = left[i] * right[i].
4. This avoids division and runs in O(n) time.
*/

class Solution{

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        // Array to store all left multiplications
        int[] left = new int[n];

        // Array to store all right multiplications
        int[] right = new int[n];

        // Build left array
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // Build right array
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        // Build final answer
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf(nums);

        for (int x : res) {
            System.out.print(x + " ");
        }
        // Output: 24 12 8 6
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)   // because of left and right arrays
*/

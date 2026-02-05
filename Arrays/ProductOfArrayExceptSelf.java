// Problem: Product of Array Except Self (LeetCode 238)
// Approach: Prefix product + Suffix product (in-place result array)
// Pattern: Prefix/Suffix + Array Traversal

/*
Important idea behind this approach:

1. For each index i, the answer should be:
      (product of all elements left of i)  ×  (product of all elements right of i)
2. First pass (left → right):
      Build prefix products in the result array.
3. Second pass (right → left):
      Multiply each position by a running suffix product.
4. No division is used, and we achieve O(n) time with O(1) extra space
   (excluding the output array).
*/

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // Step 1: build prefix products
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Step 2: multiply with suffix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix = suffix * nums[i];
        }

        return result;
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
Space Complexity: O(1) extra space (excluding result array)
*/

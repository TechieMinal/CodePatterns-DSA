// Problem: 3Sum (LeetCode 15)
// Approach: Sorting + Two Pointers
// Pattern: Two Pointers + Deduplication

/*
Important idea behind this approach:

1. Sort the array first so we can use two pointers.
2. Fix one element nums[i], then search for two numbers that sum to -nums[i].
3. Use two pointers (j = i+1, k = n-1):
   - If sum < 0 → move j++
   - If sum > 0 → move k--
   - If sum == 0 → store triplet and skip duplicates.
4. This avoids duplicate triplets and runs in O(n^2).
*/

import java.util.*;

class Solution{
    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);   // Step 1: sort array

        for (int i = 0; i < n; i++) {

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                }
                else if (sum > 0) {
                    k--;
                }
                else {
                    // Found a valid triplet
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    // Skip duplicates for j
                    while (j < k && nums[j] == nums[j - 1]) j++;

                    // Skip duplicates for k
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> res = threeSum(nums);

        for (List<Integer> triplet : res) {
            System.out.println(triplet);
        }
        // Output: [-1, -1, 2] and [-1, 0, 1]
    }
}

/*
Time Complexity: O(n^2)
Space Complexity: O(1) (excluding output list)
*/

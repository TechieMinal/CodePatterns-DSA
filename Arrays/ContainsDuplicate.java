// Problem: Contains Duplicate (LeetCode 217)
// Approach: HashSet lookup
// Pattern: Hashing

/*
Important idea behind this approach:

1. We traverse the array once.
2. For each element, we check if it already exists in a HashSet.
3. If it exists, a duplicate is found → return true.
4. If not, we add the element to the set and continue.
5. If we finish the loop with no match, return false.
*/

import java.util.HashSet;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {

            // If already present, duplicate exists
            if (set.contains(x)) {
                return true;
            }

            // Otherwise store it
            set.add(x);
        }

        return false;   // no duplicates found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};

        System.out.println(containsDuplicate(nums)); // true
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/

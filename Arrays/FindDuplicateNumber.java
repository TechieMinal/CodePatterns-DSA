// Problem: Find the Duplicate Number (LeetCode 287)
// Approach: Floyd’s Cycle Detection (Tortoise & Hare)
// Pattern: Two Pointers + Cycle Detection

/*
Important idea behind this approach:

1. Treat the array like a linked list where each value points to an index.
2. Use two pointers:
   - slow → moves 1 step at a time
   - fast → moves 2 steps at a time
3. First phase: move both until they meet inside the cycle.
4. Second phase: reset fast to start and move both 1 step.
5. Where they meet again is the duplicate number.
6. This gives O(n) time and O(1) space.
*/

class Solution{
    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Find meeting point inside the cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find start of the cycle (duplicate number)
        fast = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;   // duplicate number
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

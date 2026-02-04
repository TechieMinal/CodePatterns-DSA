// Problem: Two Sum (LeetCode 1)
// Approach: HashMap (Optimal)
// Pattern: Hashing

/*Important idea behind HashMap approach:

1.  We traverse the array once.
2.  We will use the HashMap to store the element along with index
3.  Now we will use simple math i.e. more = target - arr[i] to check if the element we need to reach our target exists in the Map or not.

Given: arr[] = {2, 6, 5, 8, 11}, target = 14
Code -    */

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        HashMapHashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int more = target - arr[i];   // what we need

            if (map.containsKey(more)) {
                // pair found
                return new int[]{ map.get(more), i };
            }

        // store current element and its index
            map.put(arr[i], i);
        }

       return new int[]{-1, -1};  // if no pair exists
    }
}

/*
Time Complexity → O(n)
Space Complexity → O(n)
*/

// Problem: Merge Intervals (LeetCode 56)
// Approach: Sorting + Linear merge
// Pattern: Greedy + Intervals

/*
Important idea behind this approach:

1. Sort all intervals by their starting time.
2. Take the first interval as current [start, end].
3. For each next interval:
   - If it overlaps with current (interval[0] <= end),
     extend 'end' to the maximum.
   - Otherwise, add the current interval to result
     and start a new one.
4. Finally add the last merged interval.
5. This runs in O(n log n) due to sorting.
*/

import java.util.*;

class Solution {
    public static int[][] merge(int[][] intervals) {

        List<int[]> res = new ArrayList<>();

        // Edge case
        if (intervals == null || intervals.length == 0)
            return new int[0][0];

        // Step 1: Sort by starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: take first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Step 3: process remaining intervals
        for (int[] i : intervals) {

            // If overlapping
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            }
            // If not overlapping
            else {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }

        // Step 4: add last interval
        res.add(new int[]{start, end});

        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] merged = merge(intervals);

        for (int[] x : merged) {
            System.out.println(Arrays.toString(x));
        }
        // Output: [1,6], [8,10], [15,18]
    }
}

/*
Time Complexity: O(n log n)
Space Complexity: O(n)
*/

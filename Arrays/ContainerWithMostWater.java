// Problem: Container With Most Water (LeetCode 11)
// Approach: Two pointers moving inward
// Pattern: Two Pointers + Greedy

/*
Important idea behind this approach:

1. Start with two pointers at both ends of the array.
2. The area is limited by the shorter height.
3. Always move the pointer pointing to the smaller height,
   because increasing width alone cannot give a better area.
4. Keep updating the maximum area found.
5. This gives an optimal O(n) solution.
*/

class Solution{

    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {

            int area = Math.min(height[left], height[right])
                        * (right - left);

            maxArea = Math.max(area, maxArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

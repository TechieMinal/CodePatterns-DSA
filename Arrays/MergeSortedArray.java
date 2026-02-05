// Problem: Merge Sorted Array (LeetCode 88)
// Approach: In-place merge using two pointers from the end
// Pattern: Two Pointers

/*
Important idea behind this approach:

1. We start merging from the end of nums1 to avoid overwriting useful values.
2. Use three pointers:
   - i → last valid element of nums1
   - j → last element of nums2
   - k → last position of nums1 (final array position)
3. Compare nums1[i] and nums2[j]:
   - Place the larger one at nums1[k] and move that pointer.
4. Repeat until all elements of nums2 are merged.
5. This works in O(m+n) time without extra space.
*/

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;          // last element of nums1's valid part
        int j = n - 1;          // last element of nums2
        int k = m + n - 1;      // last position of nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If elements are still left in nums2, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        // Print result
        for (int x : nums1) {
            System.out.print(x + " ");
        }
    }
}

/*
Time Complexity: O(m + n)
Space Complexity: O(1)
*/

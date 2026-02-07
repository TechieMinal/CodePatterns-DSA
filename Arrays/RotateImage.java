// Problem: Rotate Image (LeetCode 48)
// Approach: In-place rotation using Transpose + Reverse
// Pattern: Matrix Manipulation

/*
Important idea behind this approach:

1. First, transpose the matrix (swap rows with columns).
2. Then reverse each row.
3. These two steps together rotate the matrix 90° clockwise
   without using extra space.
*/

class Solution{
    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        rotate(matrix);

        for (int[] row : matrix) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        // Output:
        // 7 4 1
        // 8 5 2
        // 9 6 3
    }
}

/*
Time Complexity: O(n^2)
Space Complexity: O(1)   // in-place
*/

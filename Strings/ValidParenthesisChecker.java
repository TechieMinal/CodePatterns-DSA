// Problem: Valid Parenthesis Checker with '*'
// Approach: Min-Max Balance (your handwritten idea)
// Pattern: Greedy

/*
Important idea behind this approach:

We maintain a possible range of open parentheses:

min = minimum possible open '(' count
max = maximum possible open '(' count

For each character:
- '('  -> both min and max increase
- ')'  -> both min and max decrease
- '*'  -> 
      max++   (treat * as '(' )
      min--   (treat * as ')' )
      min = max(min, 0)

If max < 0 at any point -> invalid

At the end, string is valid only if min == 0
*/

class Solution{
    public static boolean checkValidString(String s) {

        int min = 0;   // minimum possible '('
        int max = 0;   // maximum possible '('

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {
                min++;
                max++;
            }
            else if (ch == ')') {
                min--;
                max--;
            }
            else {   // ch == '*'
                // '*' can be '(' or ')' or empty
                min--;   // assume ')'
                max++;   // assume '('
            }

            // min cannot be negative
            if (min < 0) {
                min = 0;
            }

            // If max becomes negative, no way to balance
            if (max < 0) {
                return false;
            }
        }

        // Valid only if we can finish with zero opens
        return min == 0;
    }
}

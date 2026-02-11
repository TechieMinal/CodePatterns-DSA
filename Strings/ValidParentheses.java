// Problem: Valid Parentheses (LeetCode 20)
// Approach: Stack-based matching
// Pattern: Stack

/*
Important idea behind this approach:

1. Use a stack to store opening brackets.
2. When we see an opening bracket → push it.
3. When we see a closing bracket → pop from stack and check match.
4. If mismatch or stack is empty → invalid.
5. At the end, stack must be empty for a valid string.
*/

import java.util.Stack;

class Solution{
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Push all opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else {   // closing bracket case

                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();   // must be empty if valid
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/

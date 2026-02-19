// Problem: Valid Anagram (LeetCode 242)
// Approach: Character frequency counting
// Pattern: Hashing / Frequency Array

/*
Important idea behind this approach:

1. If lengths of the two strings are different → they cannot be anagrams.
2. Use an array of size 26 to count character frequencies.
3. Increase count for characters in string s.
4. Decrease count for characters in string t.
5. If all counts become zero → strings are anagrams.
*/

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        // Step 1: length check
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];   // only lowercase English letters

        // Step 2: count characters of s
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Step 3: subtract characters of t
        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i) - 'a']--;
        }

        // Step 4: check all counts
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

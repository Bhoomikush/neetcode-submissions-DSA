class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] window = new int[26];

        // Count frequency of s1 and first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (java.util.Arrays.equals(s1Count, window)) {
            return true;
        }

        // Slide the window
        for (int i = s1.length(); i < s2.length(); i++) {

            // Add new character
            window[s2.charAt(i) - 'a']++;

            // Remove old character
            window[s2.charAt(i - s1.length()) - 'a']--;

            // Compare both frequency arrays
            if (java.util.Arrays.equals(s1Count, window)) {
                return true;
            }
        }

        return false;
    }
}
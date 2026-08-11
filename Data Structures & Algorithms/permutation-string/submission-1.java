class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Frequency of s1
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        // First window
        for (int i = 0; i < s1.length(); i++) {
            count2[s2.charAt(i) - 'a']++;
        }

        // Sliding window
        for (int i = s1.length(); i < s2.length(); i++) {

            if (Arrays.equals(count1, count2)) {
                return true;
            }

            // Remove left character
            count2[s2.charAt(i - s1.length()) - 'a']--;

            // Add new right character
            count2[s2.charAt(i) - 'a']++;
        }

        return Arrays.equals(count1, count2);
    }
}
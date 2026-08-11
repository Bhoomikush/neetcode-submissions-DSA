class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int[] count = new int[128];

        // Frequency of characters required from t
        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int left = 0;
        int right = 0;
        int need = t.length();

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);

            // If this character is needed
            if (count[c] > 0) {
                need--;
            }

            count[c]--;
            right++;

            // Window contains all characters of t
            while (need == 0) {

                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                count[leftChar]++;

                if (count[leftChar] > 0) {
                    need++;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}
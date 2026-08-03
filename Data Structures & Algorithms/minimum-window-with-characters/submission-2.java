
class Solution {
    public String minWindow(String s, String t) {

        // Edge case
        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> target = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Count characters of t
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }

        int have = 0;
        int need = target.size();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        // Expand window
        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            // Add current character
            window.put(c, window.getOrDefault(c, 0) + 1);

            // Requirement satisfied
            if (target.containsKey(c) &&
                window.get(c).equals(target.get(c))) {
                have++;
            }

            // Shrink window
            while (have == need) {

                // Update answer
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // Requirement broken
                if (target.containsKey(leftChar) &&
                    window.get(leftChar) < target.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}
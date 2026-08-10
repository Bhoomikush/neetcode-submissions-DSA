
class Solution {

    public String encode(List<String> strs) {

        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length());
            encoded.append("#");
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String s) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            // Find #
            int j = i;

            while (s.charAt(j) != '#') {
                j++;
            }

            // Get length
            int length = Integer.parseInt(s.substring(i, j));

            // Move after #
            i = j + 1;

            // Get actual string
            String str = s.substring(i, i + length);

            result.add(str);

            // Move to next encoded string
            i = i + length;
        }

        return result;
    }
}
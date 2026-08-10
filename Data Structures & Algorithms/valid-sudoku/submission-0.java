

class Solution {
    public boolean isValidSudoku(char[][] board) {

        // 9 rows, 9 columns, 9 boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Create sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Check every cell
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                char num = board[r][c];

                // Ignore empty cells
                if (num == '.') {
                    continue;
                }

                // Find which 3x3 box this cell belongs to
                int box = (r / 3) * 3 + (c / 3);

                // Duplicate found
                if (rows[r].contains(num) ||
                    cols[c].contains(num) ||
                    boxes[box].contains(num)) {

                    return false;
                }

                // Add number
                rows[r].add(num);
                cols[c].add(num);
                boxes[box].add(num);
            }
        }

        return true;
    }
}
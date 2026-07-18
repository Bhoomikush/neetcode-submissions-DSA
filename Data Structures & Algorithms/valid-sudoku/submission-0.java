class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Check each row
        for (int i = 0; i < 9; i++) {
            HashSet<Character> seen = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                if (seen.contains(board[i][j])) {
                    return false;
                }

                seen.add(board[i][j]);
            }
        }

        // Check each column
        for (int j = 0; j < 9; j++) {
            HashSet<Character> seen = new HashSet<>();

            for (int i = 0; i < 9; i++) {

                if (board[i][j] == '.') {
                    continue;
                }

                if (seen.contains(board[i][j])) {
                    return false;
                }

                seen.add(board[i][j]);
            }
        }

        // Check each 3x3 box
        for (int row = 0; row < 9; row += 3) {

            for (int col = 0; col < 9; col += 3) {

                HashSet<Character> seen = new HashSet<>();

                for (int i = row; i < row + 3; i++) {

                    for (int j = col; j < col + 3; j++) {

                        if (board[i][j] == '.') {
                            continue;
                        }

                        if (seen.contains(board[i][j])) {
                            return false;
                        }

                        seen.add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }
}
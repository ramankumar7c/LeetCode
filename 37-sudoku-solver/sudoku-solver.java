class Solution {
    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][] boxes = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int d = board[i][j] - '0';
                    rows[i][d] = true;
                    cols[j][d] = true;
                    boxes[getBoxIndex(i, j)][d] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int r, int c) {
        if (r == 9)
            return true;
        if (c == 9)
            return dfs(board, r + 1, 0);
        if (board[r][c] != '.')
            return dfs(board, r, c + 1);

        for (int d = 1; d <= 9; d++) {
            int boxIdx = getBoxIndex(r, c);
            if (!rows[r][d] && !cols[c][d] && !boxes[boxIdx][d]) {
                board[r][c] = (char) (d + '0');
                rows[r][d] = cols[c][d] = boxes[boxIdx][d] = true;
                if (dfs(board, r, c + 1))
                    return true;

                board[r][c] = '.';
                rows[r][d] = cols[c][d] = boxes[boxIdx][d] = false;
            }
        }
        return false;
    }

    private int getBoxIndex(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }
}
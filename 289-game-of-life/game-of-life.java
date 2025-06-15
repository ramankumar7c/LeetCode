class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;

        int[] dir = { -1, 0, 1 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                for (int x : dir) {
                    for (int y : dir) {
                        if (x == 0 && y == 0)
                            continue;
                        int ni = i + x, nj = j + y;
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n)
                            liveNeighbors += board[ni][nj] & 1;
                    }
                }
                if (board[i][j] == 1 && (liveNeighbors == 2 || liveNeighbors == 3))
                    board[i][j] |= 0b10;
                else if (board[i][j] == 0 && liveNeighbors == 3)
                    board[i][j] |= 0b10;
            }
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] >>= 1;
    }
}
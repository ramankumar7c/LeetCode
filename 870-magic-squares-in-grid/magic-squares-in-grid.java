class Solution {
    private static final int[][][] MAGIC_SQUARES = {
            { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } },
            { { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } },
            { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } },
            { { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } },
            { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } },
            { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } },
            { { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } },
            { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } }
    };

    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        for (int i = 0; i <= grid.length - 3; i++)
            for (int j = 0; j <= grid[0].length - 3; j++)
                if (isMagicSquare(grid, i, j))
                    count++;
        return count;
    }

    private boolean isMagicSquare(int[][] grid, int row, int col) {
        int[] square = new int[9];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                square[i * 3 + j] = grid[row + i][col + j];

        for (int[][] magicSquare : MAGIC_SQUARES) {
            boolean isMatch = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    if (magicSquare[i][j] != square[i * 3 + j]) {
                        isMatch = false;
                        break;
                    }
                if (!isMatch)
                    break;
            }
            if (isMatch)
                return true;
        }
        return false;
    }
}
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
            }
        }

        int maxSize = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 2; i + k <= m && j + k <= n; k++) {
                    if (isMagic(grid, rowSum, colSum, i, j, k)) {
                        maxSize = Math.max(maxSize, k);
                    }
                }
            }
        }
        return maxSize;
    }

    private boolean isMagic(int[][] grid, int[][] rowSum, int[][] colSum, int r, int c, int k) {

        int target = rowSum[r][c + k] - rowSum[r][c];

        for (int i = 0; i < k; i++)
            if (rowSum[r + i][c + k] - rowSum[r + i][c] != target)
                return false;

        for (int j = 0; j < k; j++)
            if (colSum[r + k][c + j] - colSum[r][c + j] != target)
                return false;

        int d1 = 0, d2 = 0;
        for (int i = 0; i < k; i++) {
            d1 += grid[r + i][c + i];
            d2 += grid[r + i][c + k - 1 - i];
        }

        return d1 == target && d2 == target;
    }
}
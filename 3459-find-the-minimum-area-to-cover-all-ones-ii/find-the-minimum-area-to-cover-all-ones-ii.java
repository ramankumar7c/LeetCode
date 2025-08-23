class Solution {
    int[][] ps;
    int rows, cols;

    public int minimumSum(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        ps = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++)
            for (int j = 1; j <= cols; j++)
                ps[i][j] = grid[i - 1][j - 1] + ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1];

        int ans = Integer.MAX_VALUE;

        for (int c1 = 1; c1 < cols; c1++) {
            for (int c2 = c1 + 1; c2 < cols; c2++) {
                int a1 = rectArea(0, 0, rows - 1, c1 - 1);
                int a2 = rectArea(0, c1, rows - 1, c2 - 1);
                int a3 = rectArea(0, c2, rows - 1, cols - 1);
                if (a1 > 0 && a2 > 0 && a3 > 0)
                    ans = Math.min(ans, a1 + a2 + a3);
            }
        }

        for (int r1 = 1; r1 < rows; r1++) {
            for (int r2 = r1 + 1; r2 < rows; r2++) {
                int a1 = rectArea(0, 0, r1 - 1, cols - 1);
                int a2 = rectArea(r1, 0, r2 - 1, cols - 1);
                int a3 = rectArea(r2, 0, rows - 1, cols - 1);
                if (a1 > 0 && a2 > 0 && a3 > 0)
                    ans = Math.min(ans, a1 + a2 + a3);
            }
        }

        for (int c = 1; c < cols; c++) {
            for (int r = 1; r < rows; r++) {
                int a1 = rectArea(0, 0, rows - 1, c - 1);
                int a2 = rectArea(0, c, r - 1, cols - 1);
                int a3 = rectArea(r, c, rows - 1, cols - 1);
                if (a1 > 0 && a2 > 0 && a3 > 0)
                    ans = Math.min(ans, a1 + a2 + a3);

                a1 = rectArea(0, c, rows - 1, cols - 1);
                a2 = rectArea(0, 0, r - 1, c - 1);
                a3 = rectArea(r, 0, rows - 1, c - 1);
                if (a1 > 0 && a2 > 0 && a3 > 0)
                    ans = Math.min(ans, a1 + a2 + a3);
            }
        }

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                int a1 = rectArea(0, 0, r - 1, cols - 1);
                int a2 = rectArea(r, 0, rows - 1, c - 1);
                int a3 = rectArea(r, c, rows - 1, cols - 1);
                if (a1 > 0 && a2 > 0 && a3 > 0)
                    ans = Math.min(ans, a1 + a2 + a3);

                a1 = rectArea(r, 0, rows - 1, cols - 1);
                a2 = rectArea(0, 0, r - 1, c - 1);
                a3 = rectArea(0, c, r - 1, cols - 1);
                if (a1 > 0 && a2 > 0 && a3 > 0)
                    ans = Math.min(ans, a1 + a2 + a3);
            }
        }
        return ans;
    }

    private int rectArea(int r1, int c1, int r2, int c2) {
        if (r1 > r2 || c1 > c2)
            return 0;

        int minR = rows, maxR = -1;
        int minC = cols, maxC = -1;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (getOnes(i, j, i, j) > 0) {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        if (maxR == -1)
            return 0;
        return (maxR - minR + 1) * (maxC - minC + 1);
    }

    private int getOnes(int r1, int c1, int r2, int c2) {
        return ps[r2 + 1][c2 + 1] - ps[r1][c2 + 1] - ps[r2 + 1][c1] + ps[r1][c1];
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i * j == 0 || i == n - 1 || j == m - 1)
                    if (grid[i][j] == 1)
                        dfs(grid, i, j);
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                sum += grid[i][j];

        return sum;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;
        if (grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
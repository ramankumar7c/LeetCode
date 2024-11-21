class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];

        for (int[] guard : guards)
            grid[guard[0]][guard[1]] = 'G';
        for (int[] wall : walls)
            grid[wall[0]][wall[1]] = 'W';

        for (int[] guard : guards) {
            int x = guard[0], y = guard[1];

            for (int i = x - 1; i >= 0; i--) {
                if (grid[i][y] == 'W' || grid[i][y] == 'G')
                    break;
                if (grid[i][y] == 0)
                    grid[i][y] = 'g';
            }

            for (int i = x + 1; i < m; i++) {
                if (grid[i][y] == 'W' || grid[i][y] == 'G')
                    break;
                if (grid[i][y] == 0)
                    grid[i][y] = 'g';
            }

            for (int j = y - 1; j >= 0; j--) {
                if (grid[x][j] == 'W' || grid[x][j] == 'G')
                    break;
                if (grid[x][j] == 0)
                    grid[x][j] = 'g';
            }

            for (int j = y + 1; j < n; j++) {
                if (grid[x][j] == 'W' || grid[x][j] == 'G')
                    break;
                if (grid[x][j] == 0)
                    grid[x][j] = 'g';
            }
        }

        int unguarded = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    unguarded++;
            }
        }

        return unguarded;
    }
}
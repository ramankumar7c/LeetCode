class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int m = grid.length;
        int n = grid[0].length;
        int countFresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    countFresh++;
                else if (grid[i][j] == 2)
                    q.offer(new int[] { i, j });
            }
        }
        if (countFresh == 0)
            return 0;

        int step = 0;
        while (!q.isEmpty()) {
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];

                for (int[] dir : dirs) {
                    int x = row + dir[0];
                    int y = col + dir[1];

                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1)
                        continue;

                    grid[x][y] = 2;
                    q.offer(new int[] { x, y });
                    countFresh--;
                }
            }
        }
        return countFresh == 0 ? step - 1 : -1;
    }
}
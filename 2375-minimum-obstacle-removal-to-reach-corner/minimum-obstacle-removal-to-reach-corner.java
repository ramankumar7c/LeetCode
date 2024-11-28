class Solution {
    public int minimumObstacles(int[][] grid) {
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int m = grid.length;
        int n = grid[0].length;

        Deque<int[]> deque = new ArrayDeque<>();
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        deque.offer(new int[] { 0, 0 });
        dist[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int i = current[0];
            int j = current[1];

            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];

                if (x < 0 || x >= m || y < 0 || y >= n)
                    continue;

                int newDist = dist[i][j] + grid[x][y];
                if (newDist < dist[x][y]) {
                    dist[x][y] = newDist;

                    if (grid[x][y] == 0)
                        deque.offerFirst(new int[] { x, y });
                    else
                        deque.offerLast(new int[] { x, y });
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
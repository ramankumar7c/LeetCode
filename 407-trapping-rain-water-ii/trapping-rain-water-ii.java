class Solution {
    static class Cell {
        int i, j, h;

        Cell(int i, int j, int h) {
            this.i = i;
            this.j = j;
            this.h = h;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m == 0 || n == 0)
            return 0;

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.h - b.h);
        boolean[][] seen = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            seen[i][0] = seen[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            seen[0][j] = seen[m - 1][j] = true;
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int water = 0;

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] d : dirs) {
                int x = cell.i + d[0], y = cell.j + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || seen[x][y])
                    continue;
                seen[x][y] = true;

                water += Math.max(0, cell.h - heightMap[x][y]);

                pq.offer(new Cell(x, y, Math.max(cell.h, heightMap[x][y])));
            }
        }
        return water;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        boolean[][] visited = new boolean[n][n];

        minHeap.add(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = true;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int elevation = curr[0], r = curr[1], c = curr[2];

            if (r == n - 1 && c == n - 1)
                return elevation;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    minHeap.add(new int[] { Math.max(elevation, grid[nr][nc]), nr, nc });
                }
            }
        }
        return -1;
    }
}
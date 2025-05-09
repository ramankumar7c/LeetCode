class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length;
        int n = moveTime[0].length;

        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        dist[0][0] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] { 0, 0, 0 });

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentDist = current[0];
            int i = current[1];
            int j = current[2];

            if (i == m - 1 && j == n - 1)
                return currentDist;

            if (currentDist > dist[i][j])
                continue;

            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];

                if (x >= 0 && x < m && y >= 0 && y < n) {
                    int additionalTime = (i + j) % 2 + 1;
                    int newDist = Math.max(moveTime[x][y], currentDist) + additionalTime;

                    if (newDist < dist[x][y]) {
                        dist[x][y] = newDist;
                        minHeap.offer(new int[] { newDist, x, y });
                    }
                }
            }
        }
        return -1;
    }
}
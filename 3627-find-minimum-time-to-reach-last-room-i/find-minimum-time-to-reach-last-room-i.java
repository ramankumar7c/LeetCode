class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length;
        if (rows == 0)
            return -1;
        int cols = moveTime[0].length;
        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[][] time = new int[rows][cols];
        for (int[] row : time)
            Arrays.fill(row, Integer.MAX_VALUE);

        time[0][0] = 0;
        pq.offer(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentTime = current[0];
            int row = current[1];
            int col = current[2];

            if (row == rows - 1 && col == cols - 1)
                return currentTime;

            if (currentTime > time[row][col])
                continue;

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols)
                    continue;

                int newTime = Math.max(currentTime, moveTime[newRow][newCol]) + 1;
                if (newTime < time[newRow][newCol]) {
                    time[newRow][newCol] = newTime;
                    pq.offer(new int[] { newTime, newRow, newCol });
                }
            }
        }
        return -1;
    }
}
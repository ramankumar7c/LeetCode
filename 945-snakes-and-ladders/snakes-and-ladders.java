class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n * n + 1];
        queue.offer(1);
        visited[1] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == n * n)
                    return steps;

                for (int next = current + 1; next <= Math.min(current + 6, n * n); next++) {
                    int[] coordinates = getCoordinates(next, n);
                    int row = coordinates[0], col = coordinates[1];
                    int destination = board[row][col] == -1 ? next : board[row][col];

                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private int[] getCoordinates(int position, int n) {
        int row = (position - 1) / n;
        int col = (position - 1) % n;

        if (row % 2 == 1)
            col = n - 1 - col;

        row = n - 1 - row;

        return new int[] { row, col };
    }
}
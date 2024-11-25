class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int rows = 2, cols = 3;
        String goal = "123450";
        StringBuilder initialState = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                initialState.append(board[i][j]);
            }
        }

        String start = initialState.toString();
        if (start.equals(goal))
            return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String current = queue.poll();
                int zeroIndex = current.indexOf('0');
                int row = zeroIndex / cols, col = zeroIndex % cols;

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        int swapIndex = newRow * cols + newCol;
                        StringBuilder nextState = new StringBuilder(current);
                        nextState.setCharAt(zeroIndex, current.charAt(swapIndex));
                        nextState.setCharAt(swapIndex, '0');
                        String next = nextState.toString();
                        if (next.equals(goal))
                            return steps + 1;
                        if (!visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
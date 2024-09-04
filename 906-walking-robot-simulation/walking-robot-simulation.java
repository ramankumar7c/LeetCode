class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int ans = 0;
        int d = 0;
        int x = 0, y = 0;

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles)
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);

        for (int command : commands) {
            if (command == -1)
                d = (d + 1) % 4;
            else if (command == -2)
                d = (d + 3) % 4;
            else {
                for (int step = 0; step < command; step++) {
                    int nextX = x + dirs[d][0];
                    int nextY = y + dirs[d][1];

                    if (obstacleSet.contains(nextX + "," + nextY))
                        break;

                    x = nextX;
                    y = nextY;
                }
            }
            ans = Math.max(ans, x * x + y * y);
        }
        return ans;
    }
}
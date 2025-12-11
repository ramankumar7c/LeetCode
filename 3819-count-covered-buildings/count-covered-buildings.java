class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, Integer> minX = new HashMap<>();
        Map<Integer, Integer> minY = new HashMap<>();
        Map<Integer, Integer> maxX = new HashMap<>();
        Map<Integer, Integer> maxY = new HashMap<>();

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            minX.put(y, Math.min(minX.getOrDefault(y, x), x));
            maxX.put(y, Math.max(maxX.getOrDefault(y, x), x));

            minY.put(x, Math.min(minY.getOrDefault(x, y), y));
            maxY.put(x, Math.max(maxY.getOrDefault(x, y), y));
        }
        int covered = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            boolean left = y > minY.get(x);
            boolean right = y < maxY.get(x);
            boolean up = x > minX.get(y);
            boolean down = x < maxX.get(y);

            if (left && right && up && down)
                covered++;
        }
        return covered;
    }
}
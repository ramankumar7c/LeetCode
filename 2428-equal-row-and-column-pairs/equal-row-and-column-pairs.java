class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        Map<List<Integer>, Integer> rowMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++)
                row.add(grid[i][j]);
            rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
        }
        for (int j = 0; j < n; j++) {
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < n; i++)
                col.add(grid[i][j]);
            ans += rowMap.getOrDefault(col, 0);
        }
        return ans;
    }
}
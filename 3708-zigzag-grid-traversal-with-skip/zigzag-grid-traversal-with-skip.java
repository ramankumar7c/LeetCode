class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> order = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++)
                    order.add(grid[i][j]);
            } else {
                for (int j = n - 1; j >= 0; j--)
                    order.add(grid[i][j]);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < order.size(); i += 2)
            ans.add(order.get(i));

        return ans;
    }
}
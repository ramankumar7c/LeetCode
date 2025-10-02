class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], color, visited);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int startColor, int newColor, boolean[][] visited) {
        if (i < 0 || i == image.length || j < 0 || j == image[0].length)
            return;
        if (image[i][j] != startColor || visited[i][j])
            return;

        image[i][j] = newColor;
        visited[i][j] = true;

        dfs(image, i + 1, j, startColor, newColor, visited);
        dfs(image, i - 1, j, startColor, newColor, visited);
        dfs(image, i, j + 1, startColor, newColor, visited);
        dfs(image, i, j - 1, startColor, newColor, visited);
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colour = new int[graph.length];
        Arrays.fill(colour, -1);

        for (int i = 0; i < graph.length; i++) {
            if (colour[i] == -1)
                if (dfs(i, 0, graph, colour) == false)
                    return false;
        }
        return true;
    }

    private boolean dfs(int node, int col, int[][] graph, int[] colour) {
        colour[node] = col;
        for (int i : graph[node]) {
            if (colour[i] == -1) {
                if (dfs(i, 1 - col, graph, colour) == false)
                    return false;
            } else if (colour[i] == col)
                return false;
        }
        return true;
    }
}
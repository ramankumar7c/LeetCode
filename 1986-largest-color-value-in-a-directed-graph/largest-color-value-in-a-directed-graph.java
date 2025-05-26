class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges)
            graph[edge[0]].add(edge[1]);

        int[][] dp = new int[n][26];
        int[] visited = new int[n];
        int[] result = new int[1];

        for (int i = 0; i < n; i++)
            if (dfs(i, graph, colors, dp, visited, result))
                return -1;

        return result[0];
    }

    private boolean dfs(int node, List<Integer>[] graph, String colors, int[][] dp, int[] visited, int[] result) {
        if (visited[node] == 1)
            return true;
        if (visited[node] == 2)
            return false;

        visited[node] = 1;
        for (int neighbor : graph[node]) {
            if (dfs(neighbor, graph, colors, dp, visited, result))
                return true;
            for (int c = 0; c < 26; c++)
                dp[node][c] = Math.max(dp[node][c], dp[neighbor][c]);
        }

        dp[node][colors.charAt(node) - 'a']++;
        for (int c = 0; c < 26; c++)
            result[0] = Math.max(result[0], dp[node][c]);

        visited[node] = 2;
        return false;
    }
}
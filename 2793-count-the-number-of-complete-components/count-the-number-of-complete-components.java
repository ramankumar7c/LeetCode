class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int completeComponents = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);

                if (isComplete(component, adj))
                    completeComponents++;
            }
        }
        return completeComponents;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbour : adj.get(node))
            if (!visited[neighbour])
                dfs(neighbour, adj, visited, component);
    }

    private boolean isComplete(List<Integer> component, List<List<Integer>> adj) {
        int size = component.size();
        int expectedEdges = size * (size - 1) / 2;
        int actualEdges = 0;
        for (int node : component)
            actualEdges += adj.get(node).size();

        actualEdges /= 2;
        return actualEdges == expectedEdges;
    }
}
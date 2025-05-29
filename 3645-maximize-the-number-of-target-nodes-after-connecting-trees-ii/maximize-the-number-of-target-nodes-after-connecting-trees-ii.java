class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<Integer>[] graph1 = buildGraph(edges1, n);
        List<Integer>[] graph2 = buildGraph(edges2, m);

        int[] depth1 = new int[n];
        int[] depth2 = new int[m];

        dfsDepth(graph1, 0, -1, depth1);
        dfsDepth(graph2, 0, -1, depth2);

        int even1 = 0, odd1 = 0;
        for (int d : depth1)
            if (d % 2 == 0)
                even1++;
            else
                odd1++;

        int even2 = 0, odd2 = 0;
        for (int d : depth2)
            if (d % 2 == 0)
                even2++;
            else
                odd2++;

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int tree1 = (depth1[i] % 2 == 0) ? even1 : odd1;
            int tree2 = Math.max(even2, odd2);
            ans[i] = tree1 + tree2;
        }
        return ans;
    }

    private void dfsDepth(List<Integer>[] graph, int u, int parent, int[] depth) {
        for (int v : graph[u])
            if (v != parent) {
                depth[v] = depth[u] + 1;
                dfsDepth(graph, v, u, depth);
            }
    }

    private List<Integer>[] buildGraph(int[][] edges, int numNodes) {
        List<Integer>[] graph = new ArrayList[numNodes];
        for (int i = 0; i < numNodes; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }
}
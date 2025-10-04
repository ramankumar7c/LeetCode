class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            int a = pre[0], b = pre[1];
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i])
                if (!dfs(i, graph, visited, pathVisited, order))
                    return new int[0];
        }
        Collections.reverse(order);
        int[] res = new int[order.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = order.get(i);

        return res;
    }

    private boolean dfs(int node, List<List<Integer>> graph, boolean[] visited, boolean[] pathVisited,
            List<Integer> order) {
        visited[node] = true;
        pathVisited[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                if (!dfs(nei, graph, visited, pathVisited, order))
                    return false;
            } else if (pathVisited[nei])
                return false;
        }
        pathVisited[node] = false;
        order.add(node);
        return true;
    }
}
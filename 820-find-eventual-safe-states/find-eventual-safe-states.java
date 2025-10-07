class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> revGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            revGraph.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int it : graph[i]) {
                revGraph.get(it).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int it : revGraph.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0)
                    q.offer(it);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
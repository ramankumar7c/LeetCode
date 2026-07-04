class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int d = road[2];

            graph.get(a).add(new int[] { b, d });
            graph.get(b).add(new int[] { a, d });
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int city = q.poll();

            for (int[] next : graph.get(city)) {
                ans = Math.min(ans, next[1]);

                if (!visited[next[0]]) {
                    visited[next[0]] = true;
                    q.offer(next[0]);
                }
            }
        }

        return ans;
    }
}
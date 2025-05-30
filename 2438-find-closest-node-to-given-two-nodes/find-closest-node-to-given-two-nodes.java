class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        bfs(edges, node1, dist1);
        bfs(edges, node2, dist2);

        int minMaxDist = Integer.MAX_VALUE;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int currentMax = Math.max(dist1[i], dist2[i]);
                if (currentMax < minMaxDist) {
                    minMaxDist = currentMax;
                    result = i;
                } else if (currentMax == minMaxDist && i < result)
                    result = i;
            }

        }
        return result;
    }

    private void bfs(int[] edges, int start, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            int v = edges[u];
            if (v != -1 && dist[v] == -1) {
                dist[v] = dist[u] + 1;
                queue.offer(v);
            }
        }
    }
}
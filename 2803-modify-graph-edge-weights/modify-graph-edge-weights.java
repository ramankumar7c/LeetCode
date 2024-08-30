class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        final int kMax = 2_000_000_000;
        int[][] adjMatrix = new int[n][n];
        List<int[]> unknownEdges = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            Arrays.fill(adjMatrix[i], kMax);
        }
        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            if (edge[2] == -1) {
                unknownEdges.add(edge);
            } else {
                adjMatrix[u][v] = adjMatrix[v][u] = edge[2];
            }
        }

        int distToDestination = dijkstra(adjMatrix, source, destination);
        if (distToDestination < target) {
            return new int[0][];
        }

        for (int[] edge : unknownEdges) {
            final int u = edge[0];
            final int v = edge[1];
            adjMatrix[u][v] = adjMatrix[v][u] = 1;

            int currentDist = dijkstra(adjMatrix, source, destination);

            if (currentDist <= target) {
                edge[2] = 1 + (target - currentDist);
                adjMatrix[u][v] = adjMatrix[v][u] = edge[2];
            } else {
                edge[2] = 1;
            }
        }

        if (dijkstra(adjMatrix, source, destination) == target) {
            for (int[] edge : unknownEdges) {
                if (edge[2] == -1) {
                    edge[2] = 1;
                }
            }
            return edges;
        }

        return new int[0][];
    }

    private int dijkstra(int[][] adjMatrix, int src, int dst) {
        final int kMax = 2_000_000_000;
        int n = adjMatrix.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[] { 0, src });

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int d = current[0], u = current[1];

            if (u == dst) {
                return d;
            }

            for (int v = 0; v < n; ++v) {
                if (adjMatrix[u][v] < kMax && d + adjMatrix[u][v] < dist[v]) {
                    dist[v] = d + adjMatrix[u][v];
                    minHeap.offer(new int[] { dist[v], v });
                }
            }
        }

        return dist[dst];
    }
}
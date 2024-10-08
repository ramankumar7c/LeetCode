class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());
            graph.get(A).put(B, values[i]);
            graph.get(B).put(A, 1.0 / values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            String A = queries.get(i).get(0);
            String C = queries.get(i).get(1);
            ans[i] = bfs(graph, A, C);
        }
        return ans;
    }

    private double bfs(Map<String, Map<String, Double>> graph, String A, String C) {
        if (!graph.containsKey(A) || !graph.containsKey(C))
            return -1.0;
        if (A.equals(C))
            return 1.0;

        Queue<Pair<String, Double>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Pair<>(A, 1.0));
        visited.add(A);

        while (!queue.isEmpty()) {
            Pair<String, Double> current = queue.poll();
            String node = current.getKey();
            double value = current.getValue();

            if (node.equals(C))
                return value;

            Map<String, Double> neighbours = graph.get(node);
            for (Map.Entry<String, Double> entry : neighbours.entrySet()) {
                String neighbour = entry.getKey();
                double weight = entry.getValue();
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(new Pair<>(neighbour, value * weight));
                }
            }
        }
        return -1.0;
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
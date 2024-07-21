class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topologicalSort(k, rowConditions);
        int[] colOrder = topologicalSort(k, colConditions);

        if (rowOrder == null || colOrder == null)
            return new int[0][0];

        int[][] matrix = new int[k][k];
        int[] rowIndex = new int[k + 1];
        int[] colIndex = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowIndex[rowOrder[i]] = i;
            colIndex[colOrder[i]] = i;
        }

        for (int i = 0; i < k; i++)
            for (int j = 0; j < k; j++)
                if (rowIndex[i + 1] == j)
                    matrix[rowIndex[i + 1]][colIndex[i + 1]] = i + 1;

        return matrix;
    }

    private int[] topologicalSort(int k, int[][] conditions) {
        int[] inDegree = new int[k + 1];
        List<Integer>[] graph = new ArrayList[k + 1];
        for (int i = 1; i <= k; i++)
            graph[i] = new ArrayList<>();

        for (int[] condition : conditions) {
            graph[condition[0]].add(condition[1]);
            inDegree[condition[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        int[] order = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order[index++] = node;
            for (int neighbour : graph[node]) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0)
                    queue.offer(neighbour);
            }
        }
        return index == k ? order : null;
    }
}
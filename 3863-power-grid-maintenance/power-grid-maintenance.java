class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer>[] graph = new ArrayList[c + 1];
        for (int i = 1; i <= c; i++)
            graph[i] = new ArrayList<>();
        for (int[] e : connections) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int[] component = new int[c + 1];
        int compId = 0;
        for (int i = 1; i <= c; i++) {
            if (component[i] == 0) {
                compId++;
                dfs(i, compId, graph, component);
            }
        }

        Map<Integer, TreeSet<Integer>> onlineInComp = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int cid = component[i];
            onlineInComp.putIfAbsent(cid, new TreeSet<>());
            onlineInComp.get(cid).add(i);
        }
        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        List<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int cid = component[x];

            if (type == 1) {
                if (online[x])
                    result.add(x);
                else {
                    TreeSet<Integer> set = onlineInComp.get(cid);
                    if (set.isEmpty())
                        result.add(-1);
                    else
                        result.add(set.first());
                }
            } else {
                if (online[x]) {
                    online[x] = false;
                    onlineInComp.get(cid).remove(x);
                }
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++)
            res[i] = result.get(i);

        return res;
    }

    private void dfs(int node, int id, List<Integer>[] graph, int[] component) {
        Stack<Integer> st = new Stack<>();
        st.push(node);
        component[node] = id;
        while (!st.isEmpty()) {
            int cur = st.pop();
            for (int nei : graph[cur]) {
                if (component[nei] == 0) {
                    component[nei] = id;
                    st.push(nei);
                }
            }
        }
    }
}
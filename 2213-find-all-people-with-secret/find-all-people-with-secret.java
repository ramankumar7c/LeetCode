class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n);
        uf.union(0, firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            List<Integer> touched = new ArrayList<>();

            while (i < meetings.length && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];
                uf.union(x, y);
                touched.add(x);
                touched.add(y);
                i++;
            }

            for (int person : touched) {
                if (uf.find(person) != uf.find(0)) {
                    uf.reset(person);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int p = 0; p < n; p++) {
            if (uf.find(p) == uf.find(0)) {
                res.add(p);
            }
        }
        return res;
    }

    static class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            parent[find(x)] = find(y);
        }

        void reset(int x) {
            parent[x] = x;
        }
    }
}
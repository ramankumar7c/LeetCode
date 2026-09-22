class Solution {

    static class Node {
        int[] remain = new int[5];
        int prod = 1;
    }

    static class SegmentTree {
        int n, k;
        Node[] tree;

        SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            this.tree = new Node[4 * n];

            for (int i = 0; i < tree.length; i++)
                tree[i] = new Node();

            build(nums, 0, 0, n - 1);
        }

        void build(int[] nums, int cur, int left, int right) {
            if (left == right) {
                tree[cur].remain[nums[left]] = 1;
                tree[cur].prod = nums[left];
                return;
            }

            int mid = (left + right) / 2;

            build(nums, 2 * cur + 1, left, mid);
            build(nums, 2 * cur + 2, mid + 1, right);

            tree[cur] = merge(tree[2 * cur + 1], tree[2 * cur + 2]);
        }

        void update(int i, int val) {
            update(0, 0, n - 1, i, val);
        }

        void update(int treeIndex, int lo, int hi, int i, int val) {
            if (lo == hi) {
                Arrays.fill(tree[treeIndex].remain, 0);

                tree[treeIndex].remain[val] = 1;
                tree[treeIndex].prod = val;
                return;
            }

            int mid = (lo + hi) / 2;

            if (i <= mid) {
                update(2 * treeIndex + 1, lo, mid, i, val);
            } else {
                update(2 * treeIndex + 2, mid + 1, hi, i, val);
            }

            tree[treeIndex] =
                    merge(tree[2 * treeIndex + 1],
                          tree[2 * treeIndex + 2]);
        }

        Node query(int i, int j) {
            return query(0, 0, n - 1, i, j);
        }

        Node query(int treeIndex, int lo, int hi, int i, int j) {
            // Completely inside
            if (i <= lo && hi <= j) {
                return tree[treeIndex];
            }

            // Completely outside
            if (j < lo || hi < i) {
                return new Node();
            }

            int mid = (lo + hi) / 2;

            Node left =
                    query(2 * treeIndex + 1, lo, mid, i, j);

            Node right =
                    query(2 * treeIndex + 2, mid + 1, hi, i, j);

            return merge(left, right);
        }

        Node merge(Node left, Node right) {
            Node node = new Node();

            node.prod = (left.prod * right.prod) % k;

            for (int i = 0; i < k; i++) {
                node.remain[i] = left.remain[i];
            }

            for (int i = 0; i < k; i++) {
                node.remain[(i * left.prod) % k] +=
                        right.remain[i];
            }

            return node;
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] %= k;
        }

        for (int[] query : queries) {
            query[1] %= k;
        }

        int n = nums.length;

        int[] ans = new int[queries.length];

        SegmentTree tree = new SegmentTree(nums, k);

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            tree.update(index, value);

            ans[q] = tree.query(start, n - 1).remain[x];
        }

        return ans;
    }
}
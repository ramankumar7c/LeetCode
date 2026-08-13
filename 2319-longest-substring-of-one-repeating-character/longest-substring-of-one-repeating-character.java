class Solution {

    static class Node {
        char leftChar, rightChar;
        int prefix, suffix, max, len;

        Node(char c) {
            leftChar = rightChar = c;
            prefix = suffix = max = len = 1;
        }

        Node() {
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            int index = queryIndices[i];
            char c = queryCharacters.charAt(i);

            arr[index] = c;
            update(1, 0, n - 1, index, c);

            ans[i] = tree[1].max;
        }

        return ans;
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node(arr[l]);
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int l, int r, int index, char c) {
        if (l == r) {
            tree[node] = new Node(c);
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid)
            update(node * 2, l, mid, index, c);
        else
            update(node * 2 + 1, mid + 1, r, index, c);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node a, Node b) {
        Node res = new Node();

        res.len = a.len + b.len;
        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.prefix = a.prefix;

        if (a.prefix == a.len && a.rightChar == b.leftChar)
            res.prefix = a.len + b.prefix;

        res.suffix = b.suffix;

        if (b.suffix == b.len && a.rightChar == b.leftChar)
            res.suffix = b.len + a.suffix;

        res.max = Math.max(a.max, b.max);

        if (a.rightChar == b.leftChar)
            res.max = Math.max(res.max, a.suffix + b.prefix);

        return res;
    }
}
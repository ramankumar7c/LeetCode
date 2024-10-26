/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length];
        calculateHeight(root);
        calculateMaxHeightWithoutNode(root, 0, 0);

        for (int i = 0; i < queries.length; ++i) {
            ans[i] = valToMaxHeight.getOrDefault(queries[i], 0);
        }

        return ans;
    }

    private Map<Integer, Integer> valToMaxHeight = new HashMap<>();
    private Map<Integer, Integer> valToHeight = new HashMap<>();

    private int calculateHeight(TreeNode node) {
        if (node == null)
            return 0;
        int height = 1 + Math.max(calculateHeight(node.left), calculateHeight(node.right));
        valToHeight.put(node.val, height);
        return height;
    }

    private void calculateMaxHeightWithoutNode(TreeNode node, int depth, int maxHeightWithoutParent) {
        if (node == null)
            return;

        valToMaxHeight.put(node.val, maxHeightWithoutParent);

        int leftHeight = node.left != null ? valToHeight.get(node.left.val) : 0;
        int rightHeight = node.right != null ? valToHeight.get(node.right.val) : 0;

        calculateMaxHeightWithoutNode(node.left, depth + 1, Math.max(maxHeightWithoutParent, depth + rightHeight));
        calculateMaxHeightWithoutNode(node.right, depth + 1, Math.max(maxHeightWithoutParent, depth + leftHeight));
    }
}

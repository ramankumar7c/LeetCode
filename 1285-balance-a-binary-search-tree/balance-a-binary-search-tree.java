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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        storeInorder(root, nodes);
        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }

    private void storeInorder(TreeNode node, List<TreeNode> nodes) {
        if (node == null)
            return;
        storeInorder(node.left, nodes);
        nodes.add(node);
        storeInorder(node.right, nodes);
    }

    private TreeNode buildBalancedBST(List<TreeNode> nodes, int start, int end) {
        if (start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode node = nodes.get(mid);
        node.left = buildBalancedBST(nodes, start, mid - 1);
        node.right = buildBalancedBST(nodes, mid + 1, end);
        return node;
    }
}
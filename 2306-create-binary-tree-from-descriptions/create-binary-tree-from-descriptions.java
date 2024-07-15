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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> valToNode = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {
            int p = d[0];
            int c = d[1];
            int isLeft = d[2];

            valToNode.putIfAbsent(p, new TreeNode(p));
            valToNode.putIfAbsent(c, new TreeNode(c));

            TreeNode parent = valToNode.get(p);
            TreeNode child = valToNode.get(c);

            if (isLeft == 1)
                parent.left = child;
            else
                parent.right = child;

            children.add(c);
        }
        TreeNode root = null;
        for (int val : valToNode.keySet()) {
            if (!children.contains(val)) {
                root = valToNode.get(val);
                break;
            }
        }
        return root;
    }
}
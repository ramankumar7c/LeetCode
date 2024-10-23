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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        root.val = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            List<TreeNode> nodesAtLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
                nodesAtLevel.add(node);
            }

            for (TreeNode node : nodesAtLevel) {
                int nextLevelCousinsSum = levelSum;
                if (node.left != null) {
                    nextLevelCousinsSum -= node.left.val;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    nextLevelCousinsSum -= node.right.val;
                    queue.offer(node.right);
                }
                if (node.left != null)
                    node.left.val = nextLevelCousinsSum;
                if (node.right != null)
                    node.right.val = nextLevelCousinsSum;
            }
        }
        return root;
    }
}
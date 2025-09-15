/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean leftToRight = true;

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> row = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();

                if (leftToRight)
                    row.add(node.val);
                else
                    row.add(0, node.val);

                if (node.left != null)
                    nodeQueue.offer(node.left);
                if (node.right != null)
                    nodeQueue.offer(node.right);
            }
            result.add(row);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
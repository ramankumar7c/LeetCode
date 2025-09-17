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
    private TreeNode pred = null, x = null, y = null;

    public void recoverTree(TreeNode root) {
        inorder(root);
        swap(x, y);
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        if (pred != null && root.val < pred.val) {
            y = root;
            if (x == null)
                x = pred;
            else
                return;
        }
        pred = root;

        inorder(root.right);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
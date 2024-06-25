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
    private int prefix = 0;
    public TreeNode bstToGst(TreeNode root) {
        reversedInorder(root);
        return root;
    }
    private void reversedInorder(TreeNode root){
        if(root==null)
            return;

        reversedInorder(root.right);

        root.val += prefix;
        prefix = root.val;

        reversedInorder(root.left);
    }
}
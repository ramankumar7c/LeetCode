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
    int ans = 0;

    class Info {
        int sum, count;

        Info(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private Info dfs(TreeNode node) {
        if (node == null)
            return new Info(0, 0);

        Info left = dfs(node.left);
        Info right = dfs(node.right);

        int sum = node.val + left.sum + right.sum;
        int count = 1 + left.count + right.count;

        if (node.val == sum / count)
            ans++;

        return new Info(sum, count);
    }
}
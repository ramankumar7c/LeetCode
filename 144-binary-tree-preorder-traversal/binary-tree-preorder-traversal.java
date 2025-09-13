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

// Recursive
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         preOrder(root, ans);
//         return ans;
//     }

//     private void preOrder(TreeNode root, List<Integer> ans) {
//         if (root == null)
//             return;
//         ans.add(root.val);
//         preOrder(root.left, ans);
//         preOrder(root.right, ans);
//     }
// }

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return ans;
    }
}
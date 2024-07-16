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
    public String getDirections(TreeNode root, int startValue, int destValue) {

        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPath(root, startValue, pathToStart);
        findPath(root, destValue, pathToDest);

        while (pathToStart.length() > 0 && pathToDest.length() > 0
                && pathToStart.charAt(pathToStart.length() - 1) == pathToDest.charAt(pathToDest.length() - 1)) {
            pathToStart.setLength(pathToStart.length() - 1);
            pathToDest.setLength(pathToDest.length() - 1);
        }

        return "U".repeat(pathToStart.length()) + pathToDest.reverse().toString();
    }

    private boolean findPath(TreeNode root, int val, StringBuilder path) {
        if (root.val == val)
            return true;
        if (root.left != null && findPath(root.left, val, path)) {
            path.append("L");
        } else if (root.right != null && findPath(root.right, val, path)) {
            path.append("R");
        }
        return path.length() > 0;
    }
}
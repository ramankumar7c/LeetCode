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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer>toDeleteSet=new HashSet<>();
        for(int val:to_delete)
            toDeleteSet.add(val);

        if(!toDeleteSet.contains(root.val))
            ans.add(root);

        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.left!=null){
                if(toDeleteSet.contains(node.left.val)){
                    queue.add(node.left);
                    node.left=null;
                }
                else
                    queue.add(node.left);
            }
            if(node.right!=null){
                if(toDeleteSet.contains(node.right.val)){
                    queue.add(node.right);
                    node.right=null;
                }
                else
                    queue.add(node.right);
            }
            if(toDeleteSet.contains(node.val)){
                if(node.left!=null)
                    ans.add(node.left);
                if(node.right!=null)
                    ans.add(node.right);
            }
        }
        return ans;
    }
}
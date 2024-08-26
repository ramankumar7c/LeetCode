/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Deque<Node> stack = new ArrayDeque<>();
        Deque<Node> output = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            output.push(node);
            for (Node child : node.children)
                stack.push(child);
        }
        while (!output.isEmpty())
            ans.add(output.pop().val);

        return ans;
    }
}
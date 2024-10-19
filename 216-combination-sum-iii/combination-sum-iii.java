class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<State> stack = new Stack<>();
        stack.push(new State(k, n, 1, new ArrayList<>()));

        while (!stack.isEmpty()) {
            State curr = stack.pop();

            if (curr.k == 0 && curr.n == 0) {
                ans.add(new ArrayList<>(curr.path));
                continue;
            }
            if (curr.k == 0 || curr.n < 0)
                continue;

            for (int i = curr.s; i <= 9; i++) {
                List<Integer> newPath = new ArrayList<>(curr.path);
                newPath.add(i);
                stack.push(new State(curr.k - 1, curr.n - i, i + 1, newPath));
            }
        }
        return ans;
    }

    private static class State {
        int k, n, s;
        List<Integer> path;

        State(int k, int n, int s, List<Integer> path) {
            this.k = k;
            this.n = n;
            this.s = s;
            this.path = path;
        }
    }
}
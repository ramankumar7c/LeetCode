class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stack = new Stack<>();

        for (int[] interval : intervals) {
            if (stack.isEmpty() || stack.peek()[1] < interval[0])
                stack.push(interval);
            else {
                int[] top = stack.pop();
                top[1] = Math.max(top[1], interval[1]);
                stack.push(top);
            }
        }
        return stack.toArray(new int[stack.size()][]);
    }
}
class Solution {
    public int calculate(String s) {
        int ans = 0, num = 0, sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c))
                num = num * 10 + (c - '0');

            if (c == '+' || c == '-') {
                ans += sign * num;
                num = 0;
                sign = (c == '+' ? 1 : -1)*stack.peek();
            }
            if (c == '(')
                stack.push(sign);
            else if (c == ')')
                stack.pop();
        }
        return ans + sign * num;
    }
}
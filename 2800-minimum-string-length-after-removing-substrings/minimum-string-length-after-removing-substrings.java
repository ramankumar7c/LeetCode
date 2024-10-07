class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && ((c == 'B' && stack.peek() == 'A') || (c == 'D' && stack.peek() == 'C'))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size();
    }
}
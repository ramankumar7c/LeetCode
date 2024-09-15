class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray())
            if (c == '*')
                stack.pop();
            else
                stack.push(c);

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
            result.append(stack.removeLast());

        return result.toString();
    }
}
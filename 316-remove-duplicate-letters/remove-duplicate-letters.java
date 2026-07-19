class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++)
            last[s.charAt(i) - 'a'] = i;

        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (visited[ch - 'a'])
                continue;

            while (!stack.isEmpty() && stack.peekLast() > ch && last[stack.peekLast() - 'a'] > i) {
                visited[stack.peekLast() - 'a'] = false;
                stack.pollLast();
            }
            stack.offerLast(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty())
            ans.append(stack.pollFirst());

        return ans.toString();
    }
}
class Solution {
    public String robotWithString(String s) {
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        for (char c : s.toCharArray()) {
            stack.push(c);
            freq[c - 'a']--;

            char minChar = findMinChar(freq);

            while (!stack.isEmpty() && stack.peek() <= minChar)
                result.append(stack.pop());
        }
        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.toString();
    }

    private char findMinChar(int[] freq) {
        for (int i = 0; i < 26; i++)
            if (freq[i] > 0)
                return (char) ('a' + i);

        return 'z';
    }
}
class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y)
            return processGain(s, "ab", x, "ba", y);
        else
            return processGain(s, "ba", y, "ab", x);
    }

    private int processGain(String s, String first, int point1, String second, int point2) {
        int totalPoints = 0;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack1.isEmpty() && stack1.peek() == first.charAt(0) && c == first.charAt(1)) {
                stack1.pop();
                totalPoints += point1;
            } else
                stack1.push(c);
        }

        for (char c : stack1) {
            if (!stack2.isEmpty() && stack2.peek() == second.charAt(0) && c == second.charAt(1)) {
                stack2.pop();
                totalPoints += point2;
            } else
                stack2.push(c);
        }
        return totalPoints;
    }
}
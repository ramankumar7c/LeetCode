class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for (String log : logs) {
            if (log.equals("./"))
                continue;
            else if (log.equals("../")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(log);
        }
        return stack.size();
    }
}
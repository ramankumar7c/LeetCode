class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return computeWays(expression, new HashMap<>());
    }

    private List<Integer> computeWays(String s, Map<String, List<Integer>> memo) {
        if (memo.containsKey(s))
            return memo.get(s);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!Character.isDigit(ch)) {
                List<Integer> left = computeWays(s.substring(0, i), memo);
                List<Integer> right = computeWays(s.substring(i + 1), memo);
                result.addAll(left.stream().flatMap(a -> right.stream().map(b -> applyOperation(a, b, ch)))
                        .collect(Collectors.toList()));
            }
        }
        if (result.isEmpty())
            result.add(Integer.parseInt(s));

        memo.put(s, result);
        return result;
    }

    private int applyOperation(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
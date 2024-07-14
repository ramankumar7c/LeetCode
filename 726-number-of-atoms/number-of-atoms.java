class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> count = new TreeMap<>();
        int i = 0, n = formula.length();

        while (i < n) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(count);
                count = new TreeMap<>();
                i++;
            } else if (c == ')') {
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i)))
                    i++;
                int multiplier = start == i ? 1 : Integer.parseInt(formula.substring(start, i));
                if (!stack.isEmpty()) {
                    Map<String, Integer> temp = count;
                    count = stack.pop();
                    for (String key : temp.keySet())
                        count.put(key, count.getOrDefault(key, 0) + temp.get(key) * multiplier);
                }
            } else {
                int start = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i)))
                    i++;
                String element = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i)))
                    i++;
                int countOfElement = start == i ? 1 : Integer.parseInt(formula.substring(start, i));
                count.put(element, count.getOrDefault(element, 0) + countOfElement);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String key : count.keySet()) {
            sb.append(key);
            int cnt = count.get(key);
            if (cnt > 1)
                sb.append(cnt);
        }
        return sb.toString();
    }
}
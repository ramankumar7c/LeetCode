class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();

        for (char ch : num.toCharArray()) {
            while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > ch) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(ch);
        }

        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        int idx = 0;
        while (idx < stack.length() && stack.charAt(idx) == '0') {
            idx++;
        }

        String result = stack.substring(idx);

        return result.isEmpty() ? "0" : result;
    }
}
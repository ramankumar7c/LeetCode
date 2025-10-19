class Solution {
    public int calculate(String s) {
        int ans = 0, currNum = 0, prevNum = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c))
                currNum = currNum * 10 + (c - '0');
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (op == '+' || op == '-') {
                    ans += prevNum;
                    prevNum = op == '+' ? currNum : -currNum;
                } else if (op == '*')
                    prevNum *= currNum;
                else if (op == '/')
                    prevNum /= currNum;

                op = c;
                currNum = 0;
            }
        }
        return ans + prevNum;
    }
}
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int op1 = 0, op2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && s.charAt(i) != '0')
                op1++;
            else if (i % 2 == 1 && s.charAt(i) != '1')
                op1++;
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 && s.charAt(i) != '1')
                op2++;
            else if (i % 2 == 1 && s.charAt(i) != '0')
                op2++;
        }
        return Math.min(op1, op2);
    }
}
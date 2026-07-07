class Solution {
    public long sumAndMultiply(int n) {
        String num = String.valueOf(n);
        StringBuilder sb = new StringBuilder();

        int sum = 0;

        for (char c : num.toCharArray()) {
            if (c != '0') {
                sb.append(c);
                sum += c - '0';
            }
        }

        if (sb.length() == 0)
            return 0;

        return Long.parseLong(sb.toString()) * sum;
    }
}
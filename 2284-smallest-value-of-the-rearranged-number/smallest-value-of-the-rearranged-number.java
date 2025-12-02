class Solution {
    public long smallestNumber(long num) {
        String digits = String.valueOf(Math.abs(num));
        char[] ch = digits.toCharArray();
        Arrays.sort(ch);

        StringBuilder sb = new StringBuilder(String.valueOf(ch));

        if (num <= 0)
            return -1 * Long.parseLong(sb.reverse().toString());

        if (sb.charAt(0) == '0') {
            int i = 1;

            while (i < sb.length() && sb.charAt(i) == '0') {
                i++;
            }

            char c = sb.charAt(i);
            sb.setCharAt(0, c);
            sb.setCharAt(i, '0');
        }

        return Long.parseLong(sb.toString());
    }
}
class Solution {
    public long smallestNumber(long num) {
        String digits = String.valueOf(Math.abs(num));
        char[] ch = digits.toCharArray();
        Arrays.sort(ch);
        String s = new String(ch);

        StringBuilder sb = new StringBuilder(s);

        if (num <= 0)
            return -1 * Long.parseLong(sb.reverse().toString());

        if (sb.charAt(0) == '0') {
            int firstNonZeroIndex = -1;
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) != '0') {
                    firstNonZeroIndex = i;
                    break;
                }
            }
            sb.setCharAt(0, sb.charAt(firstNonZeroIndex));
            sb.setCharAt(firstNonZeroIndex, '0');
        }

        return Long.parseLong(sb.toString());
    }
}
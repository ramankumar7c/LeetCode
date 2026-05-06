class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1, sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum += widths[c - 'a'];
            if (sum > 100) {
                lines++;
                sum = widths[c - 'a'];
            }
        }
        return new int[] { lines, sum };
    }
}
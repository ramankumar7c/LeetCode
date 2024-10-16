class Solution {
    public String longestDiverseString(int a, int b, int c) {
        return longestDiverseString(a, b, c, 'a', 'b', 'c');
    }

    private String longestDiverseString(int a, int b, int c, char A, char B, char C) {
        if (a < b)
            return longestDiverseString(b, a, c, B, A, C);

        if (b < c)
            return longestDiverseString(a, c, b, A, C, B);

        if (b == 0)
            return repeat(A, Math.min(a, 2));

        int useA = Math.min(a, 2);
        int useB = (a - useA >= b) ? 1 : 0;

        return repeat(A, useA) + repeat(B, useB) + longestDiverseString(a - useA, b - useB, c, A, B, C);
    }

    private String repeat(char ch, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++)
            sb.append(ch);

        return sb.toString();
    }
}
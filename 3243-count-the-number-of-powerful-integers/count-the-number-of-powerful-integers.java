class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String a = Long.toString(start);
        String b = Long.toString(finish);
        String aWithLeadingZeros = String.format("%" + b.length() + "s", a).replace(' ', '0');
        long[][][] mem = new long[b.length()][2][2];
        for (long[][] layer : mem)
            for (long[] row : layer)
                Arrays.fill(row, -1);

        return count(aWithLeadingZeros, b, 0, limit, s, true, true, mem);
    }

    private long count(String a, String b, int i, int limit, String s, boolean tight1, boolean tight2, long[][][] mem) {
        if (i + s.length() == b.length()) {
            String aMinSuffix = tight1 ? a.substring(a.length() - s.length()) : "0".repeat(s.length());
            String bMaxSuffix = tight2 ? b.substring(b.length() - s.length()) : "9".repeat(s.length());
            long suffix = Long.parseLong(s);
            return (Long.parseLong(aMinSuffix) <= suffix && suffix <= Long.parseLong(bMaxSuffix)) ? 1 : 0;
        }
        int tight1Index = tight1 ? 1 : 0;
        int tight2Index = tight2 ? 1 : 0;
        if (mem[i][tight1Index][tight2Index] != -1)
            return mem[i][tight1Index][tight2Index];

        long res = 0;
        int minDigit = tight1 ? a.charAt(i) - '0' : 0;
        int maxDigit = tight2 ? b.charAt(i) - '0' : 9;

        for (int d = minDigit; d <= maxDigit; d++) {
            if (d > limit)
                continue;
            boolean nextTight1 = tight1 && (d == minDigit);
            boolean nextTight2 = tight2 && (d == maxDigit);
            res += count(a, b, i + 1, limit, s, nextTight1, nextTight2, mem);
        }
        mem[i][tight1Index][tight2Index] = res;
        return res;
    }
}
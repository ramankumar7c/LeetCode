class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long[] palindromes = getPalindromes(n);
        return Math.abs(palindromes[0] - num) <= Math.abs(palindromes[1] - num) ? String.valueOf(palindromes[0])
                : String.valueOf(palindromes[1]);
    }

    private long[] getPalindromes(String s) {
        long num = Long.parseLong(s);
        int length = s.length();
        long[] palindromes = new long[2];
        String half = s.substring(0, (length + 1) / 2);
        String reversedHalf = new StringBuilder(half.substring(0, length / 2)).reverse().toString();
        long candidate = Long.parseLong(half + reversedHalf);

        if (candidate >= num) {
            String prevHalf = String.valueOf(Long.parseLong(half) - 1);
            String reversedPrevHalf = new StringBuilder(prevHalf.substring(0, Math.min(prevHalf.length(), length / 2)))
                    .reverse().toString();
            if (length % 2 == 0 && Long.parseLong(prevHalf) == 0)
                palindromes[0] = 9;
            else if (length % 2 == 0 && prevHalf.equals("9"))
                palindromes[0] = Long.parseLong(prevHalf + '9' + reversedPrevHalf);
            else
                palindromes[0] = Long.parseLong(prevHalf + reversedPrevHalf);
        } else
            palindromes[0] = candidate;

        if (candidate <= num) {
            String nextHalf = String.valueOf(Long.parseLong(half) + 1);
            String reversedNextHalf = new StringBuilder(nextHalf.substring(0, length / 2)).reverse().toString();
            palindromes[1] = Long.parseLong(nextHalf + reversedNextHalf);
        } else
            palindromes[1] = candidate;

        return palindromes;
    }
}
class Solution {
    static final long LIMIT = 1_000_001L;

    int[][] factExp;
    int[] primes;
    int[] primeIdx;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int[] half = new int[26];
        int halfLen = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1)
                mid = (char) ('a' + i);
            half[i] = freq[i] / 2;
            halfLen += half[i];
        }

        buildPrimeData(halfLen);

        if (countWays(half) < k)
            return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0)
                    continue;

                half[c]--;
                long ways = countWays(half);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        if (mid != 0)
            ans.append(mid);
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private void buildPrimeData(int n) {
        if (n == 0) {
            primes = new int[0];
            factExp = new int[1][0];
            return;
        }

        boolean[] comp = new boolean[n + 1];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (!comp[i]) {
                list.add(i);
                for (long j = (long) i * i; j <= n; j += i)
                    comp[(int) j] = true;
            }
        }

        primes = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            primes[i] = list.get(i);

        primeIdx = new int[n + 1];
        Arrays.fill(primeIdx, -1);
        for (int i = 0; i < primes.length; i++)
            primeIdx[primes[i]] = i;

        factExp = new int[n + 1][primes.length];

        for (int i = 1; i <= n; i++) {
            System.arraycopy(factExp[i - 1], 0, factExp[i], 0, primes.length);

            int x = i;
            while (x > 1) {
                int p = smallestPrimeFactor(x);
                int idx = primeIdx[p];
                while (x % p == 0) {
                    factExp[i][idx]++;
                    x /= p;
                }
            }
        }
    }

    private int smallestPrimeFactor(int x) {
        for (int p : primes) {
            if (p * p > x)
                break;
            if (x % p == 0)
                return p;
        }
        return x;
    }

    private long countWays(int[] half) {
        int total = 0;
        for (int x : half)
            total += x;

        if (total == 0)
            return 1;

        int[] exp = factExp[total].clone();

        for (int x : half) {
            if (x == 0)
                continue;
            int[] sub = factExp[x];
            for (int i = 0; i < exp.length; i++)
                exp[i] -= sub[i];
        }

        long res = 1;

        for (int i = 0; i < primes.length; i++) {
            int e = exp[i];
            while (e-- > 0) {
                if (res > LIMIT / primes[i])
                    return LIMIT;
                res *= primes[i];
                if (res >= LIMIT)
                    return LIMIT;
            }
        }

        return res;
    }
}
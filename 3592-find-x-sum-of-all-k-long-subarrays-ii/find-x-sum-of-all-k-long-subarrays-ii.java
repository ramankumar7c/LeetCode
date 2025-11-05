class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        Comparator<Integer> cmp = (a, b) -> {
            int fa = freq.getOrDefault(a, 0);
            int fb = freq.getOrDefault(b, 0);
            if (fa != fb)
                return fb - fa;
            return b - a;
        };

        TreeSet<Integer> top = new TreeSet<>(cmp);
        TreeSet<Integer> rest = new TreeSet<>(cmp);
        long sumTop = 0;

        for (int i = 0; i < n; i++) {
            int in = nums[i];

            if (freq.containsKey(in)) {
                if (top.remove(in))
                    sumTop -= (long) in * freq.get(in);
                else
                    rest.remove(in);
            }
            freq.put(in, freq.getOrDefault(in, 0) + 1);

            if (top.size() < x) {
                top.add(in);
                sumTop += (long) in * freq.get(in);
            } else
                rest.add(in);

            sumTop = balance(top, rest, freq, x, sumTop);

            if (i >= k) {
                int out = nums[i - k];
                if (top.remove(out))
                    sumTop -= (long) out * freq.get(out);
                else
                    rest.remove(out);

                int newF = freq.get(out) - 1;
                if (newF == 0)
                    freq.remove(out);
                else {
                    freq.put(out, newF);
                    rest.add(out);
                }
                sumTop = balance(top, rest, freq, x, sumTop);
            }

            if (i >= k - 1)
                ans[i - k + 1] = sumTop;
        }

        return ans;
    }

    private long balance(TreeSet<Integer> top, TreeSet<Integer> rest, Map<Integer, Integer> freq, int x, long sumTop) {

        while (top.size() > x) {
            int v = top.pollLast();
            sumTop -= (long) v * freq.get(v);
            rest.add(v);
        }
        while (top.size() < x && !rest.isEmpty()) {
            int v = rest.pollFirst();
            top.add(v);
            sumTop += (long) v * freq.get(v);
        }

        while (!rest.isEmpty() && !top.isEmpty()) {
            int bestRest = rest.first();
            int worstTop = top.last();

            int fBest = freq.getOrDefault(bestRest, 0);
            int fWorst = freq.getOrDefault(worstTop, 0);

            if (fBest > fWorst || (fBest == fWorst && bestRest > worstTop)) {
                top.pollLast();
                rest.pollFirst();
                sumTop -= (long) worstTop * fWorst;
                sumTop += (long) bestRest * fBest;

                top.add(bestRest);
                rest.add(worstTop);
            } else
                break;
        }
        return sumTop;
    }
}
class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();

        for (int x : nums)
            freq.put((long) x, freq.getOrDefault((long) x, 0) + 1);

        int ans = 1;

        if (freq.containsKey(1L)) {
            int ones = freq.get(1L);
            ans = Math.max(ans, (ones % 2 == 0) ? ones - 1 : ones);
        }

        for (long start : freq.keySet()) {
            if (start == 1)
                continue;

            long cur = start;
            int len = 0;

            while (true) {
                int cnt = freq.getOrDefault(cur, 0);

                if (cnt == 0) {
                    if (len > 0)
                        len--;
                    break;
                }

                if (cnt == 1) {
                    len++;
                    break;
                }

                len += 2;

                cur = cur * cur;
                if (cur > 1_000_000_000L) {
                    len--;
                    break;
                }
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}
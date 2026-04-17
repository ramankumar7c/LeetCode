class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] minDist = new int[n];
        Arrays.fill(minDist, n);
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int i = 0; i < n * 2; ++i) {
            int index = i % n;
            int num = nums[index];
            if (lastSeen.containsKey(num)) {
                int prevIndex = lastSeen.get(num) % n;
                int d = i - prevIndex;
                minDist[index] = Math.min(minDist[index], d);
                minDist[prevIndex] = Math.min(minDist[prevIndex], d);
            }
            lastSeen.put(num, i);
        }

        for (final int query : queries)
            ans.add(minDist[query] == n ? -1 : minDist[query]);

        return ans;
    }
}
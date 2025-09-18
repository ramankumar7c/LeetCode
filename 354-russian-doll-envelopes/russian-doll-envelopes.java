class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++)
            heights[i] = envelopes[i][1];

        return lengthOfLIS(heights);
    }

    private int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        for (int num : nums) {
            int i = Collections.binarySearch(sub, num);
            if (i < 0)
                i = -(i + 1);
            if (i == sub.size())
                sub.add(num);
            else
                sub.set(i, num);
        }
        return sub.size();
    }
}
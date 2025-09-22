class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            int count = freq.getOrDefault(num, 0) + 1;
            freq.put(num, count);
            maxFreq = Math.max(maxFreq, count);
        }

        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet())
            if (entry.getValue() == maxFreq)
                ans += entry.getValue();

        return ans;
    }
}
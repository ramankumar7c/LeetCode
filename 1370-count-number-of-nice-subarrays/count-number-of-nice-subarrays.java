class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int count = 0;
        int oddCount = 0;

        for (int num : nums) {
            if (num % 2 == 1)
                oddCount++;

            if (prefixCount.containsKey(oddCount - k))
                count += prefixCount.get(oddCount - k);

            prefixCount.put(oddCount, prefixCount.getOrDefault(oddCount, 0) + 1);
        }
        return count;
    }
}
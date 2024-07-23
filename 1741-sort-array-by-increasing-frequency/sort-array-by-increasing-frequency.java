class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums)
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
        entryList.sort((a, b) -> {
            if (a.getValue().equals(b.getValue()))
                return b.getKey() - a.getKey();

            return a.getValue() - b.getValue();
        });
        int[] result = new int[nums.length];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            int num = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++)
                result[index++] = num;
        }
        return result;
    }
}
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int x : basket1)
            freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
        for (int x : basket2)
            freqMap.put(x, freqMap.getOrDefault(x, 0) - 1);
        
        List<Integer> excess = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey(), val = entry.getValue();
            if (val % 2 != 0) return -1;
            for (int i = 0; i < Math.abs(val) / 2; ++i)
                excess.add(key);
        }

        if (excess.isEmpty()) return 0;

        Collections.sort(excess);
        int minValue = Math.min(Arrays.stream(basket1).min().getAsInt(), Arrays.stream(basket2).min().getAsInt());

        long cost = 0;
        int half = excess.size() / 2;
        for (int i = 0; i < half; ++i)
            cost += Math.min(excess.get(i), 2 * minValue);

        return cost;
    }
}
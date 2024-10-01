class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();

        for (int a : arr) {
            int remainder = (a % k + k) % k;
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        for (int remainder : remainderCount.keySet()) {
            int count = remainderCount.get(remainder);

            if (remainder == 0) {
                if (count % 2 != 0)
                    return false;
            } else {
                int complementCount = remainderCount.getOrDefault(k - remainder, 0);
                if (count != complementCount)
                    return false;
            }
        }
        return true;
    }
}
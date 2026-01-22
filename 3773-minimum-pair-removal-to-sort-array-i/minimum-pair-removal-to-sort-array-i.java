class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Long> list = new ArrayList<>();
        for (int x : nums)
            list.add((long) x);

        int operations = 0;

        while (!isNonDecreasing(list)) {
            int idx = 0;
            long minSum = Long.MAX_VALUE;

            for (int i = 0; i < list.size() - 1; i++) {
                long sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }

            list.set(idx, minSum);
            list.remove(idx + 1);
            operations++;
        }

        return operations;
    }

    private boolean isNonDecreasing(List<Long> list) {
        for (int i = 1; i < list.size(); i++)
            if (list.get(i) < list.get(i - 1))
                return false;

        return true;
    }
}
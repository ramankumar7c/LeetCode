class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < k; i++)
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

        ans[0] = getXSum(freq, x);

        for (int i = k; i < n; i++) {
            int remove = nums[i - k];
            freq.put(remove, freq.get(remove) - 1);
            if (freq.get(remove) == 0)
                freq.remove(remove);

            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            ans[i - k + 1] = getXSum(freq, x);
        }

        return ans;
    }

    private int getXSum(Map<Integer, Integer> freq, int x) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue()))
                return b.getValue() - a.getValue();
            return b.getKey() - a.getKey();
        });

        int sum = 0, count = 0;
        for (Map.Entry<Integer, Integer> e : list) {
            if (count == x)
                break;
            sum += e.getKey() * e.getValue();
            count++;
        }
        return sum;
    }
}
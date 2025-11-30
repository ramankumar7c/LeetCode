class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                min = Math.min(min, i - j);
                if (min == 1)
                    return 1;
            }
            map.put(reverse(nums[i]), i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int reverse(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + (num % 10);
            num /= 10;
        }
        return reversed;
    }
}
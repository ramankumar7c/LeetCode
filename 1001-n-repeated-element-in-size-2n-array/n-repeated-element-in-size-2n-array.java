class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count == n)
                return num;
            map.put(num, count);
        }
        return -1;
    }
}
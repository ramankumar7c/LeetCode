class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int count = freq.getOrDefault(nums[i], 0) + 1;
            freq.put(nums[i], count);
            if (!list.contains(nums[i]) && count > n / 3) {
                list.add(nums[i]);
            }
        }
        return list;
    }
}
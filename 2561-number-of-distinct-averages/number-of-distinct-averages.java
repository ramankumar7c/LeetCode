class Solution {
    public int distinctAverages(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < n / 2; i++)
            set.add(nums[i] + nums[n - 1 - i]);

        return set.size();
    }
}
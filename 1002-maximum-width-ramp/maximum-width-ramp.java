class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++)
            indices[i] = i;

        Arrays.sort(indices, (a, b) -> Integer.compare(nums[a], nums[b]));

        int ans = 0;
        int minIndex = n;

        for (int i : indices) {
            ans = Math.max(ans, i - minIndex);
            minIndex = Math.min(minIndex, i);
        }
        return ans;
    }
}
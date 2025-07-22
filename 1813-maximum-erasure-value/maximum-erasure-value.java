class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int sum = 0, currSum = 0;

        for (int l = 0, r = 0; r < nums.length; r++) {
            while (!seen.add(nums[r])) {
                currSum -= nums[l];
                seen.remove(nums[l++]);
            }
            currSum += nums[r];
            sum = Math.max(sum, currSum);
        }
        return sum;
    }
}
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();

        int[] bucket = new int[max + 1];
        for (int num : nums)
            bucket[num] += num;

        int prev2 = 0, prev1 = 0;
        for (int num : bucket) {
            int curr = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
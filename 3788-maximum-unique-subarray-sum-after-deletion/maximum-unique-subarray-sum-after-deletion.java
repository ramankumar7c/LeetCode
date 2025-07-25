class Solution {
    public int maxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;

        for (int num : nums) {
            max = Math.max(max, num);
            if (num > 0 && set.add(num))
                sum += num;
        }

        return max <= 0 ? max : sum;
    }
}
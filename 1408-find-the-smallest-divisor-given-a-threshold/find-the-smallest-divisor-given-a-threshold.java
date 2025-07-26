class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        int ans = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumOfDiv(nums, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    private int sumOfDiv(int[] nums, int mid) {
        int sum = 0;
        for (int num : nums)
            sum += (int) Math.ceil((double) num / mid);

        return sum;
    }
}
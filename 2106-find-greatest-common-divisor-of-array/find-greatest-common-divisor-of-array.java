class Solution {
    public int findGCD(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        while (max != 0) {
            int temp = max;
            max = min % max;
            min = temp;
        }
        return min;
    }
}
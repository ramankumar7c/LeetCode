class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int len = happiness.length;
        long sum = 0;
        int decrement = 0;

        Arrays.sort(happiness);
        for (int i = len - 1; i >= len - k; i--) {
            sum += Math.max(0, happiness[i] - decrement);
            decrement++;
        }
        return sum;
    }
}
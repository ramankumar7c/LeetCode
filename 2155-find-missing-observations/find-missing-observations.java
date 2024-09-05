class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int targetSum = (rolls.length + n) * mean;
        int currentSum = Arrays.stream(rolls).sum();
        int missingSum = targetSum - currentSum;

        if (missingSum < n || missingSum > n * 6)
            return new int[] {};

        int baseValue = missingSum / n;
        int remainder = missingSum % n;

        int[] result = new int[n];
        Arrays.fill(result, baseValue);

        for (int i = 0; i < remainder; i++)
            result[i]++;

        return result;
    }
}
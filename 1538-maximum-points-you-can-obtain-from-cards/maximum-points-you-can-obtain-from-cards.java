class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0, rightSum = 0, maxSum = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++)
            leftSum += cardPoints[i];
        maxSum = leftSum;

        if (k == n)
            return maxSum;

        int rIndex = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rIndex--];
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }
}
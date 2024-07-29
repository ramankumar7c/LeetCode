class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;

        int[] leftLess = new int[n];
        int[] leftGreater = new int[n];
        int[] rightLess = new int[n];
        int[] rightGreater = new int[n];

        for (int i = 1; i < n; i++) {
            leftLess[i] = 0;
            leftGreater[i] = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i])
                    leftLess[i]++;
                else if (rating[j] > rating[i])
                    leftGreater[i]++;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            rightLess[i] = 0;
            rightGreater[i] = 0;
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i])
                    rightLess[i]++;
                else if (rating[j] > rating[i])
                    rightGreater[i]++;
            }
        }
        for (int i = 1; i < n - 1; i++)
            ans += leftLess[i] * rightGreater[i] + leftGreater[i] * rightLess[i];

        return ans;
    }
}
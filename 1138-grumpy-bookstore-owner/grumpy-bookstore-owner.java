class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int i, totalSatisfied = 0;
        for (i = 0; i < customers.length; i++)
            if (grumpy[i] == 0)
                totalSatisfied += customers[i];

        int additionalSatisfied = 0;
        int currentWindowSatisfied = 0;

        for (i = 0; i < minutes; i++)
            if (grumpy[i] == 1)
                currentWindowSatisfied += customers[i];
        additionalSatisfied = currentWindowSatisfied;

        for (i = minutes; i < customers.length; i++) {
            if (grumpy[i] == 1)
                currentWindowSatisfied += customers[i];
            if (grumpy[i - minutes] == 1)
                currentWindowSatisfied -= customers[i - minutes];
            additionalSatisfied = Math.max(additionalSatisfied, currentWindowSatisfied);
        }
        return totalSatisfied + additionalSatisfied;
    }
}
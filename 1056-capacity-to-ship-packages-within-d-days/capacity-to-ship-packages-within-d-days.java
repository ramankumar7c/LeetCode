class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            int noOfDays = DaysFind(weights, mid);
            if (noOfDays <= days)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    private int DaysFind(int[] weights, int capacity) {
        int days = 1, load = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] + load > capacity) {
                load = weights[i];
                days++;
            } else
                load += weights[i];
        }
        return days;
    }
}
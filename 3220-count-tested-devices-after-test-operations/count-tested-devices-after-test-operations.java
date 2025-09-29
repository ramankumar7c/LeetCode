class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > 0) {
                count++;
                decrease(batteryPercentages, i + 1);
            }
        }
        return count;
    }

    private void decrease(int[] arr, int index) {
        for (int i = index; i < arr.length; i++) {
            arr[i] = arr[i] - 1;
        }
    }
}
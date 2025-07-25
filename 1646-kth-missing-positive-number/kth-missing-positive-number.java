class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missingCount = 0;
        int index = 0;
        int current = 1;

        while (missingCount < k) {
            if (index < arr.length && arr[index] == current)
                index++;
            else {
                missingCount++;
                if (missingCount == k)
                    return current;
            }
            current++;
        }
        return -1;
    }
}
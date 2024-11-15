class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left < n - 1 && arr[left] <= arr[left + 1])
            left++;

        if (left == n - 1)
            return 0;

        while (right > 0 && arr[right - 1] <= arr[right])
            right--;

        int ans = Math.min(n - 1 - left, right);

        for (int i = 0; i <= left; i++) {
            int j = binarySearch(arr, arr[i], right, n - 1);
            if (j != -1)
                ans = Math.min(ans, j - i - 1);
        }
        return ans;
    }

    private int binarySearch(int[] arr, int value, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] >= value)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start < arr.length ? start : -1;
    }
}
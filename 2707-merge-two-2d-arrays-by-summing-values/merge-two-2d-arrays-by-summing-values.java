class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] result = new int[m + n][2];
        int i = 0, j = 0, index = 0;
        while (i < m && j < n) {
            if (nums1[i][0] == nums2[j][0]) {
                result[index][0] = nums1[i][0];
                result[index][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                result[index][0] = nums1[i][0];
                result[index][1] = nums1[i][1];
                i++;
            } else {
                result[index][0] = nums2[j][0];
                result[index][1] = nums2[j][1];
                j++;
            }
            index++;
        }
        while (i < m) {
            result[index][0] = nums1[i][0];
            result[index][1] = nums1[i][1];
            i++;
            index++;
        }
        while (j < n) {
            result[index][0] = nums2[j][0];
            result[index][1] = nums2[j][1];
            j++;
            index++;
        }
        return Arrays.copyOf(result, index);
    }
}
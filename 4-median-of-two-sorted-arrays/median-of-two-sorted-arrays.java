class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;

        int l = 0, r = m;
        while (l <= r) {
            int i = (l + r) / 2;
            int j = (m + n + 1) / 2 - i;

            int Aleft = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int Aright = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int Bleft = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int Bright = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                if ((m + n) % 2 == 0)
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                else
                    return Math.max(Aleft, Bleft);
            } else if (Aleft > Bright)
                r = i - 1;
            else
                l = i + 1;
        }
        return 0;
    }
}
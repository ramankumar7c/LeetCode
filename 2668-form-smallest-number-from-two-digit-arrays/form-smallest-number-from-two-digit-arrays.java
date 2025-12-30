class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        boolean[] seen = new boolean[10];

        for (int num : nums1)
            seen[num] = true;

        int commonMin = Integer.MAX_VALUE;

        for (int num : nums2)
            if (seen[num])
                commonMin = Math.min(commonMin, num);

        if (commonMin != Integer.MAX_VALUE)
            return commonMin;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums1)
            min1 = Math.min(min1, num);

        for (int num : nums2)
            min2 = Math.min(min2, num);

        if (min1 == min2)
            return min1;
        else if (min1 < min2)
            return min1 * 10 + min2;
        else
            return min2 * 10 + min1;
    }
}
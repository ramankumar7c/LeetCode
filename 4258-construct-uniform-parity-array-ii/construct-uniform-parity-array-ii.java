class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;

        for (int num : nums1) {
            if (num % 2 == 1) {
                minOdd = Math.min(minOdd, num);
            }
        }

        boolean allOdd = true;
        boolean allEven = true;

        for (int num : nums1) {
            if (num % 2 == 0 && minOdd >= num) {
                allOdd = false;
            }

            if (num % 2 == 1 && minOdd >= num) {
                allEven = false;
            }
        }

        return allOdd || allEven;
    }
}
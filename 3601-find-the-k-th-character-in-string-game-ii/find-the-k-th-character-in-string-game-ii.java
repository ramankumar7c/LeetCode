class Solution {
    public char kthCharacter(long k, int[] operations) {
        int operationsCount = (int) Math.ceil(Math.log(k) / Math.log(2));
        int increases = 0;

        for (int i = operationsCount - 1; i >= 0; --i) {
            long halfSize = 1L << i;
            if (k > halfSize) {
                k -= halfSize;
                increases += operations[i];
            }
        }
        return (char) ('a' + increases % 26);
    }
}
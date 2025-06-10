class Solution {
    public int maxDifference(String s) {
        int[] count = new int[26];
        int maxOdd = Integer.MIN_VALUE, minEven = Integer.MAX_VALUE;

        for (char c : s.toCharArray())
            ++count[c - 'a'];

        for (int freq : count) {
            if (freq == 0)
                continue;
            else if (freq % 2 == 0)
                minEven = Math.min(minEven, freq);
            else
                maxOdd = Math.max(maxOdd, freq);
        }
        return maxOdd - minEven;
    }
}
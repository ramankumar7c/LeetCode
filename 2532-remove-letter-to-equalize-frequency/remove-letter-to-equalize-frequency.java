class Solution {
    public boolean equalFrequency(String word) {
        int[] count = new int[26];

        for (char c : word.toCharArray())
            count[c - 'a']++;

        for (char c : word.toCharArray()) {
            count[c - 'a']--;
            if (equalFreq(count))
                return true;
            count[c - 'a']++;
        }
        return false;
    }

    private boolean equalFreq(int[] count) {
        int minFreq = Integer.MAX_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        for (int freq : count) {
            if (freq > 0) {
                minFreq = Math.min(minFreq, freq);
                maxFreq = Math.max(maxFreq, freq);
            }
        }
        return minFreq == maxFreq;
    }
}
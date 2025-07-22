class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : word1.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        for (char c : word2.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) - 1);

        for (int diff : freq.values())
            if (Math.abs(diff) > 3)
                return false;

        return true;
    }
}
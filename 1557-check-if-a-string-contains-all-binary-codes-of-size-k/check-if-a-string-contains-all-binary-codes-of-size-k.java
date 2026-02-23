class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k || s.length() - k + 1 < Math.pow(2, k))
            return false;

        Set<String> set = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++)
            set.add(s.substring(i, i + k));

        return set.size() == Math.pow(2, k);
    }
}
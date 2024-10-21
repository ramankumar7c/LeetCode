class Solution {
    public int maxUniqueSplit(String s) {
        return dfs(s, 0, new HashSet<>());
    }

    private int dfs(String s, int start, Set<String> seen) {
        int maxSplits = 0;
        for (int i = start + 1; i <= s.length(); i++) {
            String candidate = s.substring(start, i);
            if (!seen.contains(candidate)) {
                seen.add(candidate);
                maxSplits = Math.max(maxSplits, 1 + dfs(s, i, seen));
                seen.remove(candidate);
            }
        }
        return maxSplits;
    }
}
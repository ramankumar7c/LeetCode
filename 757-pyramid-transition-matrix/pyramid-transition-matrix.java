class Solution {

    private Map<String, List<Character>> map = new HashMap<>();
    private Set<String> memo = new HashSet<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(top);
        }
        return dfs(bottom);
    }

    private boolean dfs(String bottom) {
        if (bottom.length() == 1)
            return true;
        if (memo.contains(bottom))
            return false;

        List<String> nextRows = new ArrayList<>();
        buildNextRows(bottom, 0, new StringBuilder(), nextRows);

        for (String next : nextRows) {
            if (dfs(next))
                return true;
        }

        memo.add(bottom);
        return false;
    }

    private void buildNextRows(String bottom, int idx, StringBuilder sb, List<String> result) {
        if (idx == bottom.length() - 1) {
            result.add(sb.toString());
            return;
        }

        String key = bottom.substring(idx, idx + 2);
        if (!map.containsKey(key))
            return;

        for (char c : map.get(key)) {
            sb.append(c);
            buildNextRows(bottom, idx + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
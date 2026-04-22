class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String query : queries) {
            for (String word : dictionary) {
                if (getDiff(query, word) < 3) {
                    ans.add(query);
                    break;
                }
            }
        }
        return ans;
    }

    private int getDiff(String query, String word) {
        int diff = 0;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) != word.charAt(i))
                diff++;
        }
        return diff;
    }
}
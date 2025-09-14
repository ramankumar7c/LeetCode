class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            exact.add(word);

            caseInsensitive.putIfAbsent(word.toLowerCase(), word);
            vowelInsensitive.putIfAbsent(maskVowels(word), word);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q))
                ans[i] = q;
            else if (caseInsensitive.containsKey(q.toLowerCase()))
                ans[i] = caseInsensitive.get(q.toLowerCase());
            else if (vowelInsensitive.containsKey(maskVowels(q)))
                ans[i] = vowelInsensitive.get(maskVowels(q));
            else
                ans[i] = "";
        }

        return ans;
    }

    private String maskVowels(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) >= 0)
                sb.append('*');
            else
                sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}
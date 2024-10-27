class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> keyToAnagrams = new HashMap<>();

        for(String str : strs){
            int[] charCounts = new int[26];
            for(char c : str.toCharArray())
                charCounts[c - 'a']++;

            StringBuilder keyBuilder = new StringBuilder();
            for(int count : charCounts)
                keyBuilder.append(count).append('#');

            String key = keyBuilder.toString();

            keyToAnagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(keyToAnagrams.values());
    }
}
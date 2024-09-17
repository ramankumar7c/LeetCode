class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> countA = new HashMap<>();
        Map<String, Integer> countB = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String word : s1.split(" "))
      countA.put(word, countA.getOrDefault(word, 0) + 1);

        for (String word : s2.split(" "))
            countB.put(word, countB.getOrDefault(word, 0) + 1);

        for (String word : countA.keySet())
            if (countA.get(word) == 1 && !countB.containsKey(word))
                result.add(word);

        for (String word : countB.keySet())
            if (countB.get(word) == 1 && !countA.containsKey(word))
                result.add(word);

        return result.toArray(new String[0]);
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordList.contains(endWord))
            return 0;

        Queue<String> q = new ArrayDeque<>(List.of(beginWord));

        for (int step = 1; !q.isEmpty(); step++) {
            for (int size = q.size(); size > 0; size--) {
                StringBuilder sb = new StringBuilder(q.poll());
                for (int i = 0; i < sb.length(); i++) {
                    char cache = sb.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(i, c);
                        String word = sb.toString();
                        if (word.equals(endWord))
                            return step + 1;
                        if (wordSet.contains(word)) {
                            q.offer(word);
                            wordSet.remove(word);
                        }
                    }
                    sb.setCharAt(i, cache);
                }
            }
        }
        return 0;
    }
}
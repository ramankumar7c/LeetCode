class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public int count = 0;
}

class Solution {
    private TrieNode root = new TrieNode();

    public int[] sumPrefixScores(String[] words) {
        int[] ans = new int[words.length];

        for (String word : words)
            insert(word);

        for (int i = 0; i < words.length; ++i)
            ans[i] = getScore(words[i]);

        return ans;
    }

    private void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null)
                node.children[index] = new TrieNode();
            
            node = node.children[index];
            ++node.count;
        }
    }

    private int getScore(String word) {
        TrieNode node = root;
        int score = 0;

        for (char c : word.toCharArray()) {
            node = node.children[c - 'a'];
            score += node.count;
        }
        return score;
    }
}
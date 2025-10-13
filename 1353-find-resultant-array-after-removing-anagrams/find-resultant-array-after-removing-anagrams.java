class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (!isAnagram(words[i], list.get(list.size() - 1)))
                list.add(words[i]);
        }
        return list;
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] count = new int[26];
        for (char ch : s.toCharArray())
            count[ch - 'a']++;

        for (char ch : t.toCharArray()) {
            if (count[ch - 'a'] == 0)
                return false;
            count[ch - 'a']--;
        }

        return true;
    }
}
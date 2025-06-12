class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : magazine.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        for (char c : ransomNote.toCharArray()) {
            int count = freq.getOrDefault(c, 0);
            if (count == 0)
                return false;
            freq.put(c, count - 1);
        }
        return true;
    }
}
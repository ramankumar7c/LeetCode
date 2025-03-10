class Solution {
    public long countOfSubstrings(String word, int k) {
        return substringsWithAtMost(word, k) - substringsWithAtMost(word, k - 1);
    }

    private long substringsWithAtMost(String word, int k) {
        if (k < 0)
            return 0;

        long result = 0;
        int n = word.length();
        int vowelCount = 0;
        int uniqueVowels = 0;

        Map<Character, Integer> vowelLastSeen = new HashMap<>();

        for (int left = 0, right = 0; right < n; right++) {
            char c = word.charAt(right);

            if (isVowel(c)) {
                vowelCount++;
                if (!vowelLastSeen.containsKey(c) || vowelLastSeen.get(c) < left)
                    uniqueVowels++;

                vowelLastSeen.put(c, right);
            }

            while (right - left + 1 - vowelCount > k) {
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    vowelCount--;
                    if (vowelLastSeen.get(leftChar) == left)
                        uniqueVowels--;
                }
                left++;
            }

            if (uniqueVowels == 5) {
                int minVowelPos = Math.min(
                        Math.min(
                                Math.min(vowelLastSeen.getOrDefault('a', Integer.MAX_VALUE),
                                        vowelLastSeen.getOrDefault('e', Integer.MAX_VALUE)),
                                Math.min(vowelLastSeen.getOrDefault('i', Integer.MAX_VALUE),
                                        vowelLastSeen.getOrDefault('o', Integer.MAX_VALUE))),
                        vowelLastSeen.getOrDefault('u', Integer.MAX_VALUE));
                result += minVowelPos - left + 1;
            }
        }
        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
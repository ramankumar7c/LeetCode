class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        int maxLen = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstIndex[c - 'a'] == -1)
                firstIndex[c - 'a'] = i;
            else {
                int len = i - firstIndex[c - 'a'] - 1;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}

// class Solution {
//     public int maxLengthBetweenEqualCharacters(String s) {
//         Map<Character, Integer> firstIndex = new HashMap<>();
//         int maxLen = -1;
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (firstIndex.containsKey(c)) {
//                 int len = i - firstIndex.get(c) - 1;
//                 maxLen = Math.max(maxLen, len);
//             } else
//                 firstIndex.put(c, i);
//         }
//         return maxLen;
//     }
// }
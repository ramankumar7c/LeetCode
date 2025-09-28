class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seen.contains(c))
                return c;
            seen.add(c);
        }
        return ' ';
    }
}

// class Solution {
//     public char repeatedCharacter(String s) {
//         char[] ch = s.toCharArray();
//         int index = Integer.MAX_VALUE;
//         for (int i = 0; i < s.length(); i++) {
//             for (int j = i + 1; j < s.length(); j++) {
//                 if (ch[i] == ch[j]) {
//                     index = Math.min(index, j);
//                     break;
//                 }
//             }
//         }
//         return ch[index];
//     }
// }
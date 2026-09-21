class Solution {
    public String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'A' && c <= 'Z')
                c = (char) (c + 32);

            result.append(c);
        }

        return result.toString();
    }
}

// class Solution {
//     public String toLowerCase(String s) {
//         return s.toLowerCase();
//     }
// }
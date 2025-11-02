class Solution {
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int l = 0, r = n - 1;

        while (l < r) {
            if (!Character.isLetter(arr[l]))
                l++;
            else if (!Character.isLetter(arr[r]))
                r--;
            else {
                char temp = arr[l];
                arr[l++] = arr[r];
                arr[r--] = temp;
            }
        }
        return new String(arr);
    }
}

// First Thought Solution
// class Solution {
//     public String reverseOnlyLetters(String s) {
//         StringBuilder letters = new StringBuilder();
//         for (char c : s.toCharArray())
//             if (Character.isLetter(c))
//                 letters.append(c);
//         letters.reverse();
//         String letter = letters.toString();
//         StringBuilder ans = new StringBuilder();

//         int n = s.length(), j = 0;
//         for (int i = 0; i < n; i++) {
//             if (Character.isLetter(s.charAt(i)))
//                 ans.append(letter.charAt(j++));
//             else
//                 ans.append(s.charAt(i));
//         }
//         return ans.toString();
//     }
// }
class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }
}

// class Solution {
//     public boolean hasAlternatingBits(int n) {
//         String number = Integer.toBinaryString(n);

//         for (int i = 0; i < number.length() - 1; i++) {
//             if (number.charAt(i) == number.charAt(i + 1))
//                 return false;
//         }
//         return true;
//     }
// }
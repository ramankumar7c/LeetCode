class Solution {
    public long removeZeros(long n) {
        long res = 0, place = 1;

        while (n > 0) {
            long digit = n % 10;
            if (digit != 0) {
                res += digit * place;
                place *= 10;
            }
            n /= 10;
        }
        return res;
    }
}

// Uses extra memory
// class Solution {
//     public long removeZeros(long n) {
//         String num = String.valueOf(n);
//         num = num.replace("0", "");

//         return Long.parseLong(num);
//     }
// }
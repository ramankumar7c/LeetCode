class Solution {
    public int differenceOfSums(int n, int m) {
        int totalSum = n * (n + 1) / 2;
        int nosDivBym = n / m;
        int DivSum = m * nosDivBym * (nosDivBym + 1) / 2;
        return totalSum - 2 * DivSum;
    }
}

// class Solution {
//     public int differenceOfSums(int n, int m) {
//         int Divm = 0, notDivm = 0;
//         for (int i = 1; i <= n; i++) {
//             if (i % m == 0)
//                 Divm += i;
//             else
//                 notDivm += i;
//         }
//         return notDivm - Divm;
//     }
// }
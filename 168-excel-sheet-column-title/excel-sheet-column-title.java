class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            char c = (char) ('A' + (columnNumber - 1) % 26);
            sb.append(c);
            columnNumber--;
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}

// recursive solution
// class Solution {
//     public String convertToTitle(int columnNumber) {
//         if (columnNumber <= 0)
//             return "";
//         else
//             return convertToTitle((columnNumber - 1) / 26) + (char) ('A' + (columnNumber - 1) % 26);
//     }
// }
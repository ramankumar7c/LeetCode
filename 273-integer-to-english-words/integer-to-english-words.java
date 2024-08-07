class Solution {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        return convert(num).trim();
    }

    private String[] belowTwenty = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    private String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    private String[] thousands = { "", "Thousand", "Million", "Billion" };

    private String convert(int num) {
        if (num == 0)
            return "";

        String result = "";

        for (int i = 0; num > 0; i++) {
            if (num % 1000 != 0)
                result = helper(num % 1000).trim() + " " + thousands[i] + " " + result;
            num /= 1000;
        }
        return result.trim();
    }

    private String helper(int num) {
        if (num == 0)
            return "";
        if (num < 20)
            return belowTwenty[num];
        if (num < 100)
            return tens[num / 10] + " " + belowTwenty[num % 10];

        return belowTwenty[num / 100] + " Hundred " + helper(num % 100);
    }
}
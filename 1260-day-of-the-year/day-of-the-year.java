class Solution {
    private static final int[] DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));

        int ans = 0;
        for (int i = 0; i < month - 1; i++)
            day += DAYS[i];

        if (month > 2 && isLeapYear(year))
            day++;

        return day;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

// import java.time.LocalDate;
// class Solution {
//     public int dayOfYear(String date) {
//         return LocalDate.parse(date).getDayOfYear();
//     }
// }
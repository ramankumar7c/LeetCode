class Solution {
    public String reformatDate(String date) {
        String[] parts = date.split(" ");

        String day = parts[0].replaceAll("\\D", "");
        if (day.length() == 1)
            day = "0".concat(day);

        Map<String, String> monthMap = Map.ofEntries(
                Map.entry("Jan", "01"), Map.entry("Feb", "02"),
                Map.entry("Mar", "03"), Map.entry("Apr", "04"),
                Map.entry("May", "05"), Map.entry("Jun", "06"),
                Map.entry("Jul", "07"), Map.entry("Aug", "08"),
                Map.entry("Sep", "09"), Map.entry("Oct", "10"),
                Map.entry("Nov", "11"), Map.entry("Dec", "12"));

        String month = monthMap.get(parts[1]);
        String year = parts[2];

        return year.concat("-").concat(month).concat("-").concat(day);
    }
}

// first solution
// class Solution {
//     public String reformatDate(String date) {
//         String day, month, year;
//         if (date.length() == 13) {
//             day = date.substring(0, 2);
//             month = date.substring(5, 8);
//             year = date.substring(9);
//         } else {
//             day = "0".concat(date.substring(0, 1));
//             month = date.substring(4, 7);
//             year = date.substring(8);
//         }

//         String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

//         int mon = Arrays.asList(months).indexOf(month) + 1;
//         month = String.valueOf(mon);
//         if (mon < 10)
//             month = "0".concat(month);

//         return year.concat("-").concat(month).concat("-").concat(day);
//     }
// }
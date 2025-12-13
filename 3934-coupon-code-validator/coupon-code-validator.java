class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Map<String, List<String>> map = new HashMap<>();

        String[] orders = new String[] { "electronics", "grocery", "pharmacy", "restaurant" };

        for (String order : orders)
            map.put(order, new ArrayList<>());

        for (int i = 0; i < code.length; i++) {
            if (isValidCode(code[i]) && isActive[i] && map.containsKey(businessLine[i]))
                map.get(businessLine[i]).add(code[i]);
        }

        List<String> result = new ArrayList<>();
        for (String order : orders) {
            List<String> list = map.get(order);
            Collections.sort(list);
            result.addAll(list);
        }
        return result;
    }

    private boolean isValidCode(String s) {
        return s.matches("^[a-zA-Z0-9_]+$");
    }
}

// class Solution {
//     public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
//         List<String> l1 = new ArrayList<>();
//         List<String> l2 = new ArrayList<>();
//         List<String> l3 = new ArrayList<>();
//         List<String> l4 = new ArrayList<>();

//         int n = code.length;

//         for (int i = 0; i < n; i++) {
//             if (isValidCode(code[i]) && isActive[i]) {
//                 if (businessLine[i].equals("electronics"))
//                     l1.add(code[i]);
//                 else if (businessLine[i].equals("grocery"))
//                     l2.add(code[i]);
//                 else if (businessLine[i].equals("pharmacy"))
//                     l3.add(code[i]);
//                 else if (businessLine[i].equals("restaurant"))
//                     l4.add(code[i]);
//             }
//         }
//         Collections.sort(l1);
//         Collections.sort(l2);
//         Collections.sort(l3);
//         Collections.sort(l4);

//         List<String> result = new ArrayList<>();
//         result.addAll(l1);
//         result.addAll(l2);
//         result.addAll(l3);
//         result.addAll(l4);

//         return result;
//     }

//     private boolean isValidCode(String s) {
//         return s.matches("^[a-zA-Z0-9_]+$");
//     }
// }
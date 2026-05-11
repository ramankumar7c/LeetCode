class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            for (char c : String.valueOf(num).toCharArray())
                list.add(c - '0');

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = list.get(i);

        return result;
    }
}

// class Solution {
//     public int[] separateDigits(int[] nums) {
//         List<Integer> list = new ArrayList<>();
//         String str = Arrays.toString(nums);
//         for (int i = 0; i < str.length(); i++) {
//             if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
//                 list.add(Character.getNumericValue(str.charAt(i)));
//         }
//         int[] result = new int[list.size()];
//         for (int i = 0; i < result.length; i++) {
//             result[i] = list.get(i);
//         }
//         return result;
//     }
// }
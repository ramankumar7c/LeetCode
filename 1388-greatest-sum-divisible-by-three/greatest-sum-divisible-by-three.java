class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> rem1 = new ArrayList<>();
        List<Integer> rem2 = new ArrayList<>();

        for (int num : nums) {
            sum += num;
            if (num % 3 == 1)
                rem1.add(num);
            else if (num % 3 == 2)
                rem2.add(num);
        }

        if (sum % 3 == 0)
            return sum;

        Collections.sort(rem1);
        Collections.sort(rem2);

        int mod = sum % 3;
        int result = 0;

        if (mod == 1) {
            int op1 = Integer.MAX_VALUE;
            int op2 = Integer.MAX_VALUE;

            if (!rem1.isEmpty())
                op1 = rem1.get(0);
            if (rem2.size() >= 2)
                op2 = rem2.get(0) + rem2.get(1);

            result = sum - Math.min(op1, op2);
        } else {
            int op1 = Integer.MAX_VALUE;
            int op2 = Integer.MAX_VALUE;

            if (!rem2.isEmpty())
                op1 = rem2.get(0);
            if (rem1.size() >= 2)
                op2 = rem1.get(0) + rem1.get(1);

            result = sum - Math.min(op1, op2);
        }
        return result;
    }
}
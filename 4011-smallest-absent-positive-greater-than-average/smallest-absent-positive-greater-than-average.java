class Solution {
    public int smallestAbsent(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (num > 0)
                set.add(num);
        }
        double average = (double) sum / nums.length;
        int candidate = Math.max(1, (int) Math.floor(average) + 1);
        while (true) {
            if (!set.contains(candidate))
                return candidate;
            candidate++;
        }
    }
}
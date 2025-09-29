class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int count = 0, index = 0, n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                count++;
                if (count > 1)
                    return -1;
                index = i;
            }
        }
        if (count == 0)
            return 0;
        if (nums.get(n - 1) > nums.get(0))
            return -1;
        else
            return n - (index + 1);
    }
}
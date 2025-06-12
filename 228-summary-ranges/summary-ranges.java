class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        if (nums.length == 0)
            return ans;

        for (int i = 0; i < nums.length; i++) {
            int begin = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1])
                i++;

            int end = nums[i];
            if (begin == end)
                ans.add(String.valueOf(begin));
            else
                ans.add(begin + "->" + end);
        }
        return ans;
    }
}
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= nums.length; i++)
            set.add(i);

        for (int num : nums)
            set.remove(num);

        ans.addAll(set);

        return ans;
    }
}
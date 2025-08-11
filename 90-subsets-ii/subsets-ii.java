class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int num : nums) {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSubset = new ArrayList<>(ans.get(i));
                newSubset.add(num);
                ans.add(newSubset);
            }
        }
        Set<List<Integer>> set = new HashSet<>(ans);
        ans = new ArrayList<>(set);
        return ans;
    }
}
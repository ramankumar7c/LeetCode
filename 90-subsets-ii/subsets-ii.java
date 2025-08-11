class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    private void findSubsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;
            ds.add(nums[i]);
            findSubsets(i + 1, nums, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}

// Brute Force Solution
// class Solution {
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         Arrays.sort(nums);
//         List<List<Integer>> ans = new ArrayList<>();
//         ans.add(new ArrayList<>());

//         for (int num : nums) {
//             int size = ans.size();
//             for (int i = 0; i < size; i++) {
//                 List<Integer> newSubset = new ArrayList<>(ans.get(i));
//                 newSubset.add(num);
//                 ans.add(newSubset);
//             }
//         }
//         Set<List<Integer>> set = new HashSet<>(ans);
//         ans = new ArrayList<>(set);
//         return ans;
//     }
// }
class Solution {
    public int repeatedNTimes(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2])
                return nums[i];
        }
        return nums[nums.length - 1];
    }
}

// First Thought Solution
// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         int n = nums.length / 2;
//         Map<Integer, Integer> map = new HashMap<>();

//         for (int num : nums) {
//             int count = map.getOrDefault(num, 0) + 1;
//             if (count == n)
//                 return num;
//             map.put(num, count);
//         }
//         return -1;
//     }
// }
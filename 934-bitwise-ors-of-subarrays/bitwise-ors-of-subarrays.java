class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int a : arr) {
            Set<Integer> curr = new HashSet<>();
            curr.add(a);
            for (int p : prev)
                curr.add(p | a);
            ans.addAll(curr);
            prev = curr;
        }

        return ans.size();
    }
}
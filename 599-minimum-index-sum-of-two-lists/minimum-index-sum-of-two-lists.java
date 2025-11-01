class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        ArrayList<Integer> commonIndices = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                commonIndices.add(i);
            }
        }
        int leastSum = Integer.MAX_VALUE;
        List<String> ansList = new ArrayList<>();
        for (int indices : commonIndices) {
            int currSum = indices + map1.get(list2[indices]);
            if (currSum < leastSum) {
                leastSum = currSum;
                ansList.clear();
                ansList.add(list2[indices]);
            } else if (currSum == leastSum)
                ansList.add(list2[indices]);
        }
        String[] ans = new String[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}
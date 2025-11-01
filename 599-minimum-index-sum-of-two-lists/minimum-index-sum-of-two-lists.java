class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        int leastSum = Integer.MAX_VALUE;
        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int currSum = i + map1.get(list2[i]);
                if (currSum < leastSum) {
                    leastSum = currSum;
                    ansList.clear();
                    ansList.add(list2[i]);
                } else if (currSum == leastSum)
                    ansList.add(list2[i]);
            }
        }

        return ansList.toArray(new String[0]);
    }
}
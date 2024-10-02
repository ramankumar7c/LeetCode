class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] res = new int[arr.length];

        TreeSet<Integer> sortedSet = new TreeSet<>();
        for (int num : arr)
            sortedSet.add(num);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for (int num : sortedSet)
            rankMap.put(num, rank++);

        for (int i = 0; i < arr.length; i++)
            res[i] = rankMap.get(arr[i]);

        return res;
    }
}
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        String[] str = new String[len];
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < len; i++)
            indices.add(i);

        Collections.sort(indices, (a, b) -> score[b] - score[a]);

        for (int i = 0; i < len; i++) {
            if (i == 0)
                str[indices.get(0)] = "Gold Medal";
            else if (i == 1)
                str[indices.get(1)] = "Silver Medal";
            else if (i == 2)
                str[indices.get(2)] = "Bronze Medal";
            else
                str[indices.get(i)] = String.valueOf(i + 1);
        }
        return str;
    }
}
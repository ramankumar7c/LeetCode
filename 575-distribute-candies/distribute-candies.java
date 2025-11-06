class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> candy = new HashSet<>();
        for (int candies : candyType) {
            candy.add(candies);
            if (candy.size() >= candyType.length / 2)
                break;
        }
        return candy.size();
    }
}
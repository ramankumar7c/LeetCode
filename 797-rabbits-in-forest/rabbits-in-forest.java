class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

        for (int answer : answers)
            map.put(answer, map.getOrDefault(answer, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int answer = entry.getKey();
            int count = entry.getValue();

            int groups = (count + answer) / (answer + 1);
            total += groups * (answer + 1);
        }
        return total;
    }
}
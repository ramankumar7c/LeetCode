class Solution {
    public int findPermutationDifference(String s, String t) {
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        for (int i = 0; i < t.length(); i++) {
            sum += Math.abs(i - map.get(t.charAt(i)));
        }

        return sum;
    }
}
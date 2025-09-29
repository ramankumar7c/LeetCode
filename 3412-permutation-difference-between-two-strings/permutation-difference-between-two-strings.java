class Solution {
    public int findPermutationDifference(String s, String t) {
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();

        char[] sArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            map.put(sArray[i], i);
        }

        char[] tArray = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            sum += Math.abs(i - map.get(tArray[i]));
        }

        return sum;
    }
}
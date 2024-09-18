class Solution {
    public String largestNumber(int[] nums) {
        String s = Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining(""));
        return s.startsWith("00") ? "0" : s;
    }
}
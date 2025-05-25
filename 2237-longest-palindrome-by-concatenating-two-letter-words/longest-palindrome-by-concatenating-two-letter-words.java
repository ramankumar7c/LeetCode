class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        boolean hasMiddle = false;

        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();
            if (map.getOrDefault(rev, 0) > 0) {
                ans += 4;
                map.put(rev, map.get(rev) - 1);
            } else
                map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String key : map.keySet())
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                hasMiddle = true;
                break;
            }

        if (hasMiddle)
            ans += 2;
            
        return ans;
    }
}
class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] patternArray = pattern.toCharArray();
        String[] words = s.split(" ");
        if (patternArray.length != words.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(patternArray[i])) {
                if (map.get(patternArray[i]).equals(words[i]))
                    continue;
                else
                    return false;
            } else {
                if (set.contains(words[i]))
                    return false;
                else {
                    map.put(patternArray[i], words[i]);
                    set.add(words[i]);
                }
            }
        }
        return true;
    }
}
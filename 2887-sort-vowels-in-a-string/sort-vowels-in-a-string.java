class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        String vowelSet = "AEIOUaeiou";

        for (char c : s.toCharArray())
            if (vowelSet.indexOf(c) != -1)
                vowels.add(c);

        Collections.sort(vowels);
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;
        for (char c : s.toCharArray()) {
            if (vowelSet.indexOf(c) != -1)
                result.append(vowels.get(vowelIndex++));
            else
                result.append(c);
        }

        return result.toString();
    }
}
class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        if (words1.length > words2.length)
            return areSentencesSimilar(sentence2, sentence1);

        int i = 0;
        int j = words1.length - 1;
        int k = words2.length - 1;

        while (i <= j && words1[i].equals(words2[i]))
            i++;

        while (i <= j && words1[j].equals(words2[k])) {
            j--;
            k--;
        }
        return i > j;
    }
}
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        int n = words.length;

        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;

            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth)
                    break;
                totalChars += 1 + words[last].length();
                last++;
            }
            int gaps = last - index - 1;
            StringBuilder sb = new StringBuilder();

            if (last == n || gaps == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1)
                        sb.append(" ");
                }
                while (sb.length() < maxWidth)
                    sb.append(" ");
            } else {
                int spaces = (maxWidth - totalChars) / gaps;
                int extra = (maxWidth - totalChars) % gaps;

                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= spaces; j++)
                            sb.append(" ");

                        if (extra > 0) {
                            sb.append(" ");
                            extra--;
                        }
                    }
                }
            }
            result.add(sb.toString());
            index = last;
        }
        return result;
    }
}
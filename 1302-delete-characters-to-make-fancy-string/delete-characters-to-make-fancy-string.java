class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char prev = ' ';

        for (char c : s.toCharArray()) {
            if (c == prev)
                count++;
            else
                count = 1;

            if (count < 3)
                sb.append(c);

            prev = c;
        }

        return sb.toString();
    }
}
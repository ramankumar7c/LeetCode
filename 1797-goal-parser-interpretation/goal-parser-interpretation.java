class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        int n = command.length();
        int i = 0;
        while (i < n) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
                i++;
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    sb.append('o');
                    i += 2;
                } else if (command.substring(i, i + 4).equals("(al)")) {
                    sb.append("al");
                    i += 4;
                }
            }
        }
        return sb.toString();
    }
}
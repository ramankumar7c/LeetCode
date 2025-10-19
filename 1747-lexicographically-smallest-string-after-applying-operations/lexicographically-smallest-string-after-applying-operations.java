class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        String ans = s;

        queue.offer(s);
        seen.add(s);

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            if (curr.compareTo(ans) < 0)
                ans = curr;

            String addStr = add(curr, a);
            String rotStr = rotate(curr, b);

            if (seen.add(addStr))
                queue.offer(addStr);
            if (seen.add(rotStr))
                queue.offer(rotStr);
        }

        return ans;
    }

    private String add(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2)
            arr[i] = (char) ('0' + (arr[i] - '0' + a) % 10);
        return new String(arr);
    }

    private String rotate(String s, int b) {
        int n = s.length();
        return s.substring(n - b) + s.substring(0, n - b);
    }
}
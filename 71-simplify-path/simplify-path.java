class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new ArrayDeque<>();
        for (String dir : path.split("/")) {
            if (dir.equals("") || dir.equals("."))
                continue;
            if (dir.equals("..")) {
                if (!st.isEmpty())
                    st.pollLast();
            } else
                st.addLast(dir);
        }
        return "/" + String.join("/", st);
    }
}
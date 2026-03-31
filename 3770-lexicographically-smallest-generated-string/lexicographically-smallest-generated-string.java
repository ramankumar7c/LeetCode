class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;

        char[] res = new char[len];
        Arrays.fill(res, '?');

        boolean[] fixed = new boolean[len];

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    int idx = i + j;
                    char ch = str2.charAt(j);

                    if (res[idx] != '?' && res[idx] != ch) {
                        return "";
                    }

                    res[idx] = ch;
                    fixed[idx] = true;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (res[i] == '?') {
                res[i] = 'a';
            }
        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                if (matches(res, i, str2)) {
                    boolean changed = false;

                    for (int j = m - 1; j >= 0; j--) {
                        int idx = i + j;

                        if (fixed[idx])
                            continue;

                        char original = res[idx];

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == str2.charAt(j))
                                continue;

                            res[idx] = c;

                            if (!matches(res, i, str2)) {
                                changed = true;
                                break;
                            }
                        }

                        if (changed)
                            break;
                        res[idx] = original;
                    }

                    if (!changed)
                        return "";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            boolean eq = matches(res, i, str2);

            if (str1.charAt(i) == 'T' && !eq)
                return "";
            if (str1.charAt(i) == 'F' && eq)
                return "";
        }

        return new String(res);
    }

    private boolean matches(char[] res, int start, String str2) {
        for (int j = 0; j < str2.length(); j++) {
            if (res[start + j] != str2.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
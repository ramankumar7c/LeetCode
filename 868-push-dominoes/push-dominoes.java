class Solution {
    public String pushDominoes(String dominoes) {
        char[] s = dominoes.toCharArray();
        int n = s.length;
        int[] leftForces = new int[n];
        int[] rightForces = new int[n];

        int force = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'R')
                force = n;
            else if (s[i] == 'L')
                force = 0;
            else
                force = Math.max(force - 1, 0);
            rightForces[i] = force;
        }
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == 'L')
                force = n;
            else if (s[i] == 'R')
                force = 0;
            else
                force = Math.max(force - 1, 0);
            leftForces[i] = force;
        }
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            if (leftForces[i] > rightForces[i])
                result[i] = 'L';
            else if (leftForces[i] < rightForces[i])
                result[i] = 'R';
            else
                result[i] = '.';
        }
        return new String(result);
    }
}
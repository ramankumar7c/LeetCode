class Solution {
    public int countTriples(int n) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= n; i++)
            set.add(i * i);

        int count = 0;

        for (int a : set) {
            for (int b : set)
                if (set.contains(a + b))
                    count++;
        }

        return count;
    }
}
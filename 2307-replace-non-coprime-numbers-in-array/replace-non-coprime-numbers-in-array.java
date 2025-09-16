class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Long> stack = new ArrayDeque<>();
        for (int num : nums) {
            long x = num;
            while (!stack.isEmpty() && gcd(stack.peekLast(), x) > 1)
                x = lcm(stack.removeLast(), x);

            stack.addLast(x);
        }
        List<Integer> ans = new ArrayList<>(stack.size());
        for (long val : stack)
            ans.add((int) val);

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
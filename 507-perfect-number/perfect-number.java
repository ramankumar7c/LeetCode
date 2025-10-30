class Solution {
    public boolean checkPerfectNumber(int num) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i < num; i++) {
            if (num % i == 0)
                divisors.add(i);
        }

        int sum = 0;

        for (int i = 0; i < divisors.size(); i++) {
            sum += divisors.get(i);
        }
        return sum == num;
    }
}
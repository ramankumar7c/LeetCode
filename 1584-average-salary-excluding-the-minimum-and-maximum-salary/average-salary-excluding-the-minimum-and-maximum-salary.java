class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        Arrays.sort(salary);
        int min = salary[0];
        int max = salary[n - 1];
        int totalSalary = Arrays.stream(salary).sum();

        return (totalSalary - min - max) / (double) (n - 2);
    }
}
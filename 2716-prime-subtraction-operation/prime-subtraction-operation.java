class Solution {
    public boolean primeSubOperation(int[] nums) {
        int kMax = 1000;
        List<Integer> primes = sieveEratosthenes(kMax);

        int prevNum = 0;
        for(int num : nums){
            int maxPrimeToSubtract = 0;
            for(int prime : primes){
                if(prime >= num - prevNum)
                    break;
                maxPrimeToSubtract = prime;
            }
            num -= maxPrimeToSubtract;
            if(num <= prevNum)
                return false;

            prevNum = num;
        }
        return true;
    }
    private List<Integer> sieveEratosthenes(int n){
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i * i < n; i++)
            if(isPrime[i])
                for(int j = i * i; j < n; j += i)
                    isPrime[j] = false;
                    
        for(int i = 2; i < n; i++)
            if(isPrime[i])
                primes.add(i);

        return primes;
    }
}
class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int count = 0;

        int[] primes = new int[n+1];

        for(int i = 2; i <= n; i++) {
            if(primes[i] == 1) continue;
            int j = i + i;
            while(j <= n) {
                primes[j] = 1;
                j += i;
            }
        }

        for(int i = 2; i < n; i++) {
            if(primes[i] == 0) count++;
        }
 
        return count;
    }
}
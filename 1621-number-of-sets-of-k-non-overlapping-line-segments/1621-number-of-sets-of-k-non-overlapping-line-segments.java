class Solution {
    public int numberOfSets(int n, int k) {
        long res = 1;
        int mod = 1000000007;
        int N = n + k - 1;
        int K = 2 * k;
        
        for (int i = 1; i <= K; i++) {
            res = (res * (N - i + 1)) % mod;
            res = (res * modInverse(i, mod)) % mod;
        }
        
        return (int) res;
    }
    
    private long modInverse(long base, int mod) {
        long res = 1;
        long exp = mod - 2;
        base %= mod;
        
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        
        return res;
    }
}
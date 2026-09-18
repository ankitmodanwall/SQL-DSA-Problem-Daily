class Solution {
    static final long MOD = 1_000_000_007L;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        return (int)((power(5, even) * power(4, odd)) % MOD);
    }

    private long power(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if (exp % 2 == 1)
                result = (result * base) % MOD;

            base = (base * base) % MOD;
            exp /= 2;
        }

        return result;
    }
}
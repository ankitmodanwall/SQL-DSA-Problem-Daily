class Solution {
    private static final int MOD = 1337;

    private int pow(int a, int b) {
        int result = 1;
        a %= MOD;  // Taking mod to prevent overflow
        for (int i = 0; i < b; i++) {
            result = (result * a) % MOD;
        }
        return result;
    }

    public int superPow(int a, int[] b) {
        int result = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            result = (result * pow(a, b[i])) % MOD;
            a = pow(a, 10);  // Power up for the next iteration
        }
        return result;
    }
}
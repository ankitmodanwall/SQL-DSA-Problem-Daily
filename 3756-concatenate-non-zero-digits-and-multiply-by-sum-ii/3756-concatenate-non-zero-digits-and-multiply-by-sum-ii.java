class Solution {
    private static final int MOD = 1000000007;
    private static final int MAX = 100001;
    private static final int[] pow = new int[MAX];

    static {
        pow[0] = 1;
        for (int i = 1; i < MAX; i++)
            pow[i] = (int) ((pow[i - 1] * 10L) % MOD);
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] A = new int[n + 1];
        int[] B = new int[n + 1];
        int[] len = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';            
            A[i + 1] = A[i] + d;
            
            if (d > 0) {
                B[i + 1] = (int) ((B[i] * 10L + d) % MOD);
                len[i + 1] = len[i] + 1;
            } else {
                B[i + 1] = B[i];
                len[i + 1] = len[i];
            }
        }

        int[] res = new int[queries.length];
        int i = 0;

        for (int[] q : queries) {
            int l = q[0], r = q[1] + 1;
            
            long sub = ((long) B[l] * pow[len[r] - len[l]]) % MOD;
            long x = (B[r] - sub + MOD) % MOD;
            
            res[i++] = (int) ((x * (A[r] - A[l])) % MOD);
        }

        return res;
    }
}
class Solution {
    
        public int lastStoneWeightII(int[] stones) {
    int n = stones.length, sum = 0;
    for (int s : stones) sum += s;
    int[] dp = new int[sum / 2 + 1];
    for (int i = 1; i <= n; i++) {
        for (int j = sum / 2; j >= stones[i - 1]; j--) {
            dp[j] = Math.max(dp[j], dp[j - stones[i - 1]] + stones[i - 1]);
        }
    }
    return sum - 2 * dp[sum / 2];

    }
}
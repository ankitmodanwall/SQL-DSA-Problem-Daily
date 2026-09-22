class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, nums.length-1);
    }
    int solve(int[] nums, int i ){
        if(i<0)
        return 0;
        if(dp[0] != -1)
        return dp[i];

        dp[i] = Math.max(
            solve(nums, i-1),
            nums[i] + solve(nums, i-2)
        );
        return dp[i];
    }
}
class Solution {
    public boolean canPartition(int[] nums) {
        // int n = nums.length;
        int totalsum = 0;
        for(int num : nums) totalsum += num;
        if(totalsum %2 != 0) return false;
        int targetsum = totalsum /2;
        boolean[] dp = new boolean[targetsum +1];
        dp[0] = true;
        for(int num : nums){
            for(int currsum = targetsum; currsum >= num; currsum--){
                dp[currsum] = dp[currsum] || dp[currsum - num];
                if(dp[targetsum]) return true;
            }


        }
        return dp[targetsum];
    }
}
class Solution {
    public int numTrees(int n) {
        int dp[] = new int [n+1];
        dp[0]=1;
        // dp[1]=1;
        for(int i = 1; i<=n; i++){
            if(i<=2){
                dp[i] =i; continue;
            }
            for(int k=0; k<i;k++){
                // dp[i] += dp[k-1]*dp[i-root];
                dp[i] += (dp[k] * dp[i-1-k]);
            }
        }
        return dp[n];
        
    }
}
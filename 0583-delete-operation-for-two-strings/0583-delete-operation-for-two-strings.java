class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if(m > n){
            return minDistance(word2, word1);
        }

        int[] dp = new int[m + 1];

        for(int i = 1; i <= n; i++){
            int prev = 0;

            for(int j = 1; j <= m; j++){
                int temp = dp[j];

                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[j] = 1 + prev;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                prev = temp;
            }
        }

        return n + m - 2 * dp[m];
    }
}
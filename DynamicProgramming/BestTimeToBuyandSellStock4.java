class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k+1][2];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){
                Arrays.fill(dp[i][j],0);
            }
        }
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=k;j++){
                for(int buy=0;buy<=1;buy++){
                    if(buy == 1){
                        dp[i][j][buy] = Math.max(-prices[i]+dp[i+1][j][0],dp[i+1][j][1]);
                    }
                    else{
                        dp[i][j][buy] = Math.max(prices[i]+dp[i+1][j-1][1],dp[i+1][j][0]);
                    }
                }
            }
        }
        return dp[0][k][1];
    }
}
//I wrote recurrsive code than i changed it to this Tabulation Code i Reduced Auxaliry stack space
//TC : O(N*K*2)
//SC : ((N*K*2)

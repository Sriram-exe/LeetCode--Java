class Solution {
    public int f(int idx,int target,int[] coins,int n,int[][] dp){
        if(idx==n){
            if(target==0) return 0;
            return (int)1e8;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];
        int notPick = 0+f(idx+1,target,coins,n,dp);
        int pick = (int)1e8;
        if(coins[idx]<=target){
            pick = 1+f(idx,target-coins[idx],coins,n,dp);
        }
        return dp[idx][target]=Math.min(pick,notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans = f(0,amount,coins,n,dp);
        return ans >= (int)1e8?-1:ans;
    }
}
/*Memoization Solution for Coin Change Problem f(3,110)-> will return minimum possible coins to make the target */
/*TC = O(N*Target) */
/*SC = O(N*Target) + O(Target)->ASS */

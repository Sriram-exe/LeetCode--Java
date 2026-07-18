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

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,0);
        }
        for(int i=1;i<=amount;i++){
            dp[n][i] = (int)1e8;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=amount;j++){
                int notPick = 0+dp[i+1][j];
                int pick = (int)1e8;
                if(coins[i]<=j){
                    pick = 1+dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(pick,notPick);
            }
        }
        return dp[0][amount] == (int)1e8?-1:dp[0][amount];
    }
}
/*Tabulation code for Coin Change I understand in recursion for index i it is finding minimum possible solution to make target 0*/
/*Tabulation is a bottom up approach i implemented it */
/*First i wrote base case when it at index n only at 0 it as possible to have my answer, if other than 0 when i am reached last that mean i conlcude i not 
found any solution so i do store it as maximum(1e8)*/
/* TC = O(N*Target) */
/* SC = O(N*Target) */

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] row = new int[amount+1];
        Arrays.fill(row,0);
        for(int i=1;i<=amount;i++){
            row[i] = (int)1e8;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=amount;j++){
                int notPick = 0+row[j];
                int pick = (int)1e8;
                if(coins[i]<=j){
                    pick = 1+row[j-coins[i]];
                }
                row[j] = Math.min(pick,notPick);
            }
        }
        return row[amount] == (int)1e8?-1:row[amount];
    }
}
/*I has space otimized it further because in every iteration for row(target size) i understand there are only two parameters required for dp[idx][target] that are
    itself because the next row is itself before calculating the present row and dp[idx][target-arr[idx]] that also every we are calculating from the left side 
    so we can directly use one row only */
/* TC = O(N*Target) */
/* SC = O(Target)*/

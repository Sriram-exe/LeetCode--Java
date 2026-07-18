class Solution {
    public int f(int i,int j,int[] cuts,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int idx = i;idx<=j;idx++){
            int cost = cuts[j+1]-cuts[i-1]+f(i,idx-1,cuts,dp)+f(idx+1,j,cuts,dp);
            mini = Math.min(cost,mini);
        }
        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int c = cuts.length;
        int[] cut = new int[c+2];
        cut[0] = 0;
        cut[c+1] = n;
        int[][] dp = new int[c+1][c+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        for(int i=1;i<=c;i++){
            cut[i] = cuts[i-1];
        }
        return f(1,c,cut,dp);
    }
}
Partiation dp problem 
/*First i am sorting the cuts array because to get correct values of cuts[j+1]-cuts[i-1]*/
/*TC = O(C^3) nearly */
/*SC = O(C^2) for dp + O(C) for Recursion Auxaliry Stack Space*/

/*Tablulation Code*/
class Solution {
    // public int f(int i,int j,int[] cuts,int[][] dp){
    //     if(i>j) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int mini = Integer.MAX_VALUE;
    //     for(int idx = i;idx<=j;idx++){
    //         int cost = cuts[j+1]-cuts[i-1]+f(i,idx-1,cuts,dp)+f(idx+1,j,cuts,dp);
    //         mini = Math.min(cost,mini);
    //     }
    //     return dp[i][j] = mini;
    // }
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int c = cuts.length;
        int[] cut = new int[c+2];
        cut[0] = 0;
        cut[c+1] = n;
        int[][] dp = new int[c+2][c+2];
        for(int[] row:dp){
            Arrays.fill(row,0);
        }
        for(int i=1;i<=c;i++){
            cut[i] = cuts[i-1];
        }
        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
                if(i>j) continue;
                int mini = Integer.MAX_VALUE;
                for(int idx = i;idx<=j;idx++){
                    int cost = cut[j+1]-cut[i-1]+dp[i][idx-1]+dp[idx+1][j];
                    mini = Math.min(cost,mini);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }
}
/*TC = O(C^3) SC = O((C+2)^2) reduced Auxaliry Stack Space through Tabulation*/
/*I updated the dp array to C+2 from C+1 because of the requirement in loops */



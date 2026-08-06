class Solution {
    public int fun(int i,int j,String s,String t,int[][] dp){
        if(i==1){
            if(j==1 && s.charAt(i-1)==t.charAt(j-1)) return 1;
            if(j==0) return 1;
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int pick = 0;
        if(i>0 && j>0 && s.charAt(i-1)==t.charAt(j-1)){
            pick = fun(i-1,j-1,s,t,dp);
        }
        int notPick = fun(i-1,j,s,t,dp);
        return dp[i][j] = pick+notPick;
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return fun(n,m,s,t,dp);
    }
}
//Recursion Code 
//TC : O(M*N)
//SC : O(N*M) + O(N)

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,0);
        }
        if(s.charAt(0)==t.charAt(0)) dp[1][1] = 1;
        
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int pick = 0;
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                int notPick = 0;
                dp[i][j] += dp[i-1][j];
            }
        }
        return dp[n][m];
    }
}
//Done Bottom Up Approach 
//TC : O(N*M)
//SC : O(N*M) eleminated Auxaliry Space Complexity 

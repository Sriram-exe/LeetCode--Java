class Solution {
    public int f(int i,int j,String s1,String s2,int[][] dp){
        if(i==0||j==0){
            if(i==0 && j>0) return 0;
            if(i==0 && j==0) return 1;
            if(j==0 && i>0 &&  s1.charAt(i-1)=='*') return f(i-1,j,s1,s2,dp);
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(i>0 && j>0 && s1.charAt(i-1)==s2.charAt(j-1)){
            return dp[i][j] = f(i-1,j-1,s1,s2,dp);
        }
        if(s1.charAt(i-1)=='?'){
            return dp[i][j] = f(i-1,j-1,s1,s2,dp);
        }
        if(s1.charAt(i-1)=='*'){
            int left = f(i,j-1,s1,s2,dp);
            int right = f(i-1,j,s1,s2,dp);
            if(left==1||right==1) return dp[i][j] = 1;
            else dp[i][j] = 0;
        }
        return 0;
    }
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(n,m,p,s,dp)==1;
    }
}
//TC : O(M*N)
//SC : O(M*N) + O(Max(s,p) -> recursion stack space 

class Solution {
    public boolean isMatch(String p, String s) {
        int n = s.length();
        int m = p.length();
        if(n==0 && m==0) return true;
        boolean[][] dp = new boolean[n+1][m+1];
        for(boolean[] row:dp){
            Arrays.fill(row,false);
        }
        if(n>0 && m>0 && s.charAt(0)==p.charAt(0)){
            dp[0][0] = true;
        }
        if(n>0 && s.charAt(0)=='?'){
            dp[0][0] = true;
        }
        for(int i=1;i<=n;i++){
            if(s.charAt(i-1)=='*'){
                dp[i][0] = true;
            }
            else break;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(s.charAt(i-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                if(s.charAt(i-1)=='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}
//Converted to tabulation Code 
//TC : O(N*M) 
//SC : O(N*M) elimenated extra Auxalery stack space complexity

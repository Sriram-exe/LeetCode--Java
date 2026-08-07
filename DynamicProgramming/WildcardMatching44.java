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

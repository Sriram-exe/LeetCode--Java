class Solution {
    public int f(int i,int j1,int j2,int[][] grid,int n,int m,int[][][] dp){
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return (int)-1e8;
        }
        if(i==n-1){
            if(j1==j2) return grid[i][j1];
            return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        int maxi = 0;
        for(int dj1 = (j1-1);dj1<=(j1+1);dj1++){
            for(int dj2 = (j2-1); dj2<=(j2+1);dj2++){
                int val = 0;
                if(j1==j2) val = grid[i][j1];
                else val = grid[i][j1]+grid[i][j2];
                val += f(i+1,dj1,dj2,grid,n,m,dp);
                maxi = Math.max(val,maxi);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int[][] row:dp){
            for(int[] j:row){
                Arrays.fill(j,-1);
            }
        }
        return f(0,0,m-1,grid,n,m,dp);
    }
}
/*for every i'th row i am going and checking for maximum possibility for roboat 1 and roboat 2*/
/*TC = O(N*M*M) */
/*SC = O(N*M*M)->dp array + O(N) recursion stack space*/




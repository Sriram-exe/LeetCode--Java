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

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] next = new int[m][m];
        int[][] temp = new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j) next[i][j] = grid[n-1][i];
                else next[i][j] = (grid[n-1][i]+grid[n-1][j]);
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j1 = 0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi = 0;
                    for(int dj1 = (j1-1);dj1<=(j1+1);dj1++){
                        for(int dj2 = (j2-1);dj2<=(j2+1);dj2++){
                            int val = 0;
                            if(dj1<0||dj1>=m||dj2<0||dj2>=m){
                                val = (int)-1e8;
                            }
                            else{
                                if(j1==j2){
                                    val = grid[i][j1];
                                }
                                else{
                                    val = grid[i][j1]+grid[i][j2];
                                }
                                val += next[dj1][dj2];
                            }
                            maxi = Math.max(val,maxi);
                        }
                    }
                    temp[j1][j2] = maxi;
                }
            }
            for(int j1 = 0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    next[j1][j2] = temp[j1][j2];
                }
            }
        }
        return next[0][m-1];
    }
}
/* Tabulation Solution */
/* i am following same idea in tabulation*/
/* TC = O(N*M*M) ->this may take some more extra time than memoization because we every time computing every row total */
/* SC = O2(M*M)-> i otimized to 2 2d arrays */


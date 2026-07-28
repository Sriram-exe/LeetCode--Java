class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row,0);
        }
        for(int i=n-1;i>=0;i--){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int diag = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down,diag);
            }
        }
        return dp[0][0];
    }
}

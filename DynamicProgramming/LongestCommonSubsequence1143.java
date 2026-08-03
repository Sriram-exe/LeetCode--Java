class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row,0);
        }
        if(text1.charAt(0)==text2.charAt(0)){
            dp[0][0] = 1;
        }
        for(int i=1;i<n;i++){
            if(text1.charAt(i)==text2.charAt(0)){
                dp[i][0] = 1;
            }
            else dp[i][0] = dp[i-1][0];
        }
        for(int j=1;j<m;j++){
            if(text1.charAt(0)==text2.charAt(j)){
                dp[0][j] = 1;
            }
            else dp[0][j] = dp[0][j-1];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                int first = 0;
                if(text1.charAt(i)==text2.charAt(j)){
                    first = 1+dp[i-1][j-1];
                    dp[i][j] = first;
                }
                else{
                    int second = dp[i-1][j];
                    int third = dp[i][j-1];
                    dp[i][j] = Math.max(second,third);
                }
            }
        }
        return dp[n-1][m-1];
    }
}
//Done a lot of things that was not passed at first i observe i did mistake at base case conversion in this tabulation code 
/*From the not passing test cases of leetcode i got my mistake at conversion of base case but i got a doubt when if there are not shown test cases there i will 
  face problem but by practicing like this i got mistake when i am converting base case so by practicing only i will know my strengths and weakness from this 
  story i learn practicing is the main key for problem solving thinking */
// TC : O(N*M) N-> length of first string and M-> is the length of second string tex2
// SC : O(N*M) for dp array 

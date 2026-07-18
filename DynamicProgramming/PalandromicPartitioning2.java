class Solution {
    public boolean isPalandrome(int i,int j,String s){
        int start = i;
        int end = j;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp,0);
        for(int i=n-1;i>=0;i--){
            int count = 0;
            int mini = Integer.MAX_VALUE;
            for(int idx = i;idx<n;idx++){
                if(isPalandrome(i,idx,s)){
                    count = 1+dp[idx+1];
                    mini = Math.min(count,mini);
                }
            }
            dp[i]=mini;
        }
        return dp[0]-1;
    }
}
/*Tabulation Solution for Palandromic Pariation*/
/*TC = O(N^3) nearly */
/*SC = O(N) for dp array */

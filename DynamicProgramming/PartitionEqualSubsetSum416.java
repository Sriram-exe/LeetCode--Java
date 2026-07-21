class Solution {
    public boolean f(int idx,int sum,int[] nums,int n,int[][] dp){
        if(idx==n-1){
            if(sum==0 || nums[n-1]==sum) return true;
            return false;
        }
        if(dp[idx][sum]!=-1) return dp[idx][sum]==1;
        boolean pick = false;
        if(nums[idx]<=sum) pick = f(idx+1,sum-nums[idx],nums,n,dp);
        boolean notPick = f(idx+1,sum,nums,n,dp);
        if(pick||notPick){
            dp[idx][sum] = 1;
        }
        else{
            dp[idx][sum] = 0;
        }
        return pick||notPick;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            sum+= nums[i];
        }
        if(sum%2!=0) return false;
        int[][] dp = new int[n][(sum/2)+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(0,sum/2,nums,n,dp);
    }
}


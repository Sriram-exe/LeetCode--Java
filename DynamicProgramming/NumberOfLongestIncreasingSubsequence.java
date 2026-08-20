class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int maxi = 1;
        for(int i=0;i<n;i++){
            for(int prevIdx = 0;prevIdx<i;prevIdx++){
                if(nums[i]>nums[prevIdx] && dp[prevIdx]+1>dp[i]){
                    dp[i] = dp[prevIdx]+1;
                    cnt[i] = cnt[prevIdx];
                }
                else if(nums[i]>nums[prevIdx] && dp[prevIdx]+1 == dp[i]){
                    cnt[i] += cnt[prevIdx];
                }
            }
            if(dp[i]>maxi){
                maxi = dp[i];
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxi){
                ans+= cnt[i];
            }
        }
        return ans;
        
    }
}

// I used a count array to track maximum path for dp[i]
// TC : O(N^2) + O(N) 
// SC : O(N)+O(N) 

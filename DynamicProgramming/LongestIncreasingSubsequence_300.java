class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int idx = 0;idx<n;idx++){
            for(int prev = 0;prev<idx;prev++){
                if(nums[prev]<nums[idx]){
                    if(dp[prev]+1>dp[idx]){
                        dp[idx] = dp[prev]+1;
                    }
                }
            }
            maxi = Math.max(dp[idx],maxi);
        }
        return maxi;
    }
}
/*Why is this dynamic Programming solution beacuse dp Storing previous indexes */
/*dp[idx] represents longest increasing subsequence till idx */
/*TC = O(n^2) */
/*SC = O(N) */

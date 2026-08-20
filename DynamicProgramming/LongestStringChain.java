class Solution {
    public boolean compare(String s1,String s2){
        if(s1.length()-s2.length()!=1) return false;
        int i=0;
        int j=0;
        int n = s1.length();
        int m = s2.length();
        while(i<n && j<m){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return m==j;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int n = words.length;
        int[] dp = new int[n];
        int maxi = 1;
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int prevIdx = 0;prevIdx<i;prevIdx++){
                if(compare(words[i],words[prevIdx])){
                    if(dp[prevIdx]+1>dp[i]){
                        dp[i] = dp[prevIdx]+1;
                    }
                }
            }
            if(dp[i]>maxi){
                maxi = dp[i];
            }
        }
        return maxi;
    }
}

// Used LIS techinique
// TC : O(N^2)*(words[(n-1)/2].length())
// SC : O(N) for dp array 

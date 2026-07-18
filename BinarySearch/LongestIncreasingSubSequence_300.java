class Solution {
    public int BinarySearch(ArrayList<Integer> li, int ele){
        int low = 0;
        int high = li.size()-1;
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(li.get(mid)>=ele){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        ArrayList<Integer> li = new ArrayList<>();
        li.add(nums[0]);
        int len = 1;
        for(int idx = 1;idx<n;idx++){
            if(nums[idx]>li.get(li.size()-1)){
                li.add(nums[idx]);
                len++;
            }
            else{
                int index = BinarySearch(li,nums[idx]);
                li.set(index, nums[idx]);
            }
        }
        return len;
    }
}
/*TC = O(NlogN)*/
/*SC = O(N) for ArrayList*/
/*Here i am not creating LIS arrayList wiht actual LIS elements i am only creating LIS to get length by storing them in a particluar order*/





















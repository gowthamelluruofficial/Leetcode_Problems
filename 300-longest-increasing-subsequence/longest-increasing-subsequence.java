class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n<=0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int mx = -1;
        int ans = 1;
        for(int i=1; i<n; i++){
            mx = 0;
            for(int j=i-1; j>=0; j--){
                if(nums[j]<nums[i]){
                    mx = Math.max(dp[j],mx);
                }
            }
            dp[i] = mx + 1;
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }
}
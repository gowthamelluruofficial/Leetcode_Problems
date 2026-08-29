class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return helper(0,-1,nums);
    }
    public int helper(int i, int prev, int[] nums){
        if(i==nums.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int skip = helper(i+1,prev,nums);
        int take = 0;
        if(prev==-1 || nums[i]>nums[prev]){ 
            take = 1 + helper(i + 1, i, nums);
        }
        return dp[i][prev+1] = Math.max(skip,take);
    }
}
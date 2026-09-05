class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[n][2];
        int val = nums[0];
        int mn = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            mn = Math.min(mn,nums[i]);
            ans[i][1] = mn;
        }
        int mx = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            mx = Math.max(mx,nums[i]);
            ans[i][0] = mx;
        }
        for(int i=0; i<n; i++){
            val = ans[i][0]-ans[i][1];
            if(val<=k) return i;
        }
        return -1;
    }
}
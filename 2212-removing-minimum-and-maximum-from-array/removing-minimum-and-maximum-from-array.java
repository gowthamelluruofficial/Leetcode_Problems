class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int mx = nums[0];
        int mn = nums[0];
        int ans = 0;
        int mx_i = -1;
        int mn_i = -1;
        for(int i=0; i<n; i++){
            if(nums[i]>mx) mx = nums[i];
            if(nums[i]<mn) mn = nums[i];
        }
        for(int i=0; i<n; i++){
            if(nums[i]==mx){
                mx_i = i;
            }
            if(nums[i]==mn){
                mn_i = i;
            }
        }
        int mn1 = Math.max(mx_i,mn_i)+1;
        int m = Math.min(mx_i, mn_i);
        int y = Math.max(mx_i, mn_i);
        int mn2 = (m+1)+(n-y);
        int mn3 = (n-m);
        return Math.min(mn1,Math.min(mn2,mn3));
    }
}
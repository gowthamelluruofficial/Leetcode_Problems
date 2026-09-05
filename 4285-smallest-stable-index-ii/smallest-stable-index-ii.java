class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] mn = new int[n];
        mn[n-1] = nums[n-1];
        int max = nums[0];
        int min = nums[n-1];
        for(int i=0; i<n; i++){
            min = Math.min(min,nums[n-1-i]);
            mn[n-i-1] = min;
        }
        for(int i=0; i<n; i++){
            max = Math.max(max,nums[i]);
            int val = max-mn[i];
            if(val<=k) return i;
        }
        return -1;
    }
}
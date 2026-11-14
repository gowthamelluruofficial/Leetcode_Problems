class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=l; i<=r; i++){
            for(int j=0; j<=n-i; j++){
                sum = 0;
                for(int k=j; k<j+i; k++){
                    sum += nums.get(k);
                }
                if(sum>0) ans = Math.min(ans,sum);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
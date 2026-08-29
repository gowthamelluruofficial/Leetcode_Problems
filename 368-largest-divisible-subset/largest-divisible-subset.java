class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int mx = 0;
        for(int i=1; i<n; i++){
            mx = 0;
            for(int j=i-1; j>=0; j--){
                if(nums[i]%nums[j]==0){
                    mx = Math.max(mx,dp[j]);
                }
            }
            dp[i] = mx + 1;
        }
        int ans = 0;
        int ans_i = -1;
        for(int i=0; i<n; i++){
            if(dp[i]>ans){
                ans = dp[i];
                ans_i = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        int i = ans_i;
        result.add(nums[i]);
        int j = 0;
        boolean done = false;
        while(i>=0){
            j = i-1;
            done = false;
            while(j>=0){
                if(dp[i]==dp[j]+1 && nums[i]%nums[j]==0){
                    result.add(nums[j]);
                    done = true;
                    i = j;
                    break;
                }else{
                    j--;
                }
            }
            if(!done) break;
        }
        Collections.reverse(result);
        return result;
    }
}
class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return helper(n-1,m-1,new StringBuilder(word1),new StringBuilder(word2));
    }
    public int helper(int i, int j, StringBuilder a, StringBuilder b){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j] = helper(i-1,j-1,a,b);
        int replace = 1+helper(i-1,j-1,a,b);
        int remove = 1+helper(i-1,j,a,b);
        int insert = 1+helper(i,j-1,a,b);
        return dp[i][j] = Math.min(replace,Math.min(remove,insert));
    }
}
class Solution {
    int[][] dp;
    public int lcs(int i, int j, StringBuilder a, StringBuilder b){
        int n = a.length();
        int m = b.length();
        if(i>=n || j>=m) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j] = 1+lcs(i+1,j+1,a,b);
        return dp[i][j] = Math.max(lcs(i,j+1,a,b),lcs(i+1,j,a,b));
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder a = new StringBuilder(s);
        StringBuilder b = new StringBuilder(s);
        int n = s.length();
        dp = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i],-1);
        return lcs(0,0,a,b.reverse());
    }
}
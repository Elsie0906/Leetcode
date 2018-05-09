class Solution {
 /* Top-dpwn */   
    int[] dp = new int[59];
    public int integerBreak(int n) {
        if (n < 3) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        return max(n);
    }
    
    int max(int n) {
        if (n < 5) {
            return n;
        }
        if (dp[n] == 0) {
            int max = 0;
            for (int i = 1; i <= n/2; i++) {
                max = Math.max(max, max(i) * max(n-i));
            }
            dp[n] = max;
        }
        return dp[n];
    }    
/*    bottom-up
    public int integerBreak(int n) {
       int[] dp = new int[n + 1];
       dp[1] = 1;
       for(int i = 2; i <= n; i ++) {
           for(int j = 1; j < i; j ++) {
               dp[i] = Math.max(dp[i], (Math.max(j,dp[j])) * (Math.max(i - j, dp[i - j])));
           }
       }
       return dp[n];        
    }
*/    
}
/*
* "no 3 adjacent posts have the same color"
*/

class Solution {
    public int numWays(int n, int k) {
        // dynamic programming: OPT(n) = (k-1) * [OPT(n-1) + OPT(n-2)]
        // OPT(1): k, OPT(2): k*k
    
        if( n==0 || k==0)        // special case
            return 0;
        
        int[] dp = new int[n+1];
    
        // initialize
        dp[1] = k;                // n==1
        if( n==1 )  return dp[n];
        
        dp[2] = k*k;             // n==2
        if( n==2)   return dp[n];
        
        for(int i=3; i<dp.length; i++){
            dp[i] = (k-1) * (dp[i-1] + dp[i-2]);
        }
        
        //System.out.println("dp[n]: " + dp[n]);
        
        return dp[n]; // dummy code
    }
}
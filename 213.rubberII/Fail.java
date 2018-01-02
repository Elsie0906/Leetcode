/*
* need backtracking
*/

class Fail {
    public int rob(int[] nums) {
        
        if( nums.length == 0)       // empty list
            return 0;
        
        if( nums.length == 1)       // only one node
            return nums[0];
        
        if( nums.length == 2)       // two nodes
            return Math.max(nums[0], nums[1]);
        
        if( nums.length == 3){
            return Math.max(nums[2], Math.max(nums[0], nums[1]));
        }
        
        // dynamic programming from index: 1 ~ N-1 (get rid of start)
        
        int val = -1;
        
        int[] dp = new int[nums.length];
        
        dp[1] = nums[1]; 
        dp[2] = nums[2];
        dp[3] = Math.max(dp[2], dp[1] + nums[3]);
            
        for(int i=4; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2],dp[i-3]) + nums[i];
            dp[i] = Math.max(dp[i], dp[i-1]);
        } 
        
        printOut(dp);

        
        if( nums.length%2 == 1){        // odd
                dp[0] = Math.max(dp[nums.length-2], dp[nums.length-3] + nums[0]);
        }
        else{
                dp[0] = Math.max(dp[nums.length-3], dp[nums.length-2] + nums[0]);
        }
            
        
        //printOut(dp);
        
        val = Math.max(dp[0], dp[nums.length-1]);
        
        return val;
    }
    
    private void printOut(int[] dp){
        System.out.println();
        for(int i=0; i<dp.length; i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}
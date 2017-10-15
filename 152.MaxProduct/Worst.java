class Solution {
    public int maxProduct(int[] nums) {
        
        // error handling
        
        if( nums.length == 0)
            return 0;
     
        /* create a triangular matrix, space O(N^2/2) -> O(N)
        // input:[2,3,-2,4]
        // layer 0: 2                                 <- dp[0]
        // layer 1: 3, 3*2                            <- dp[0],dp[1]
        // layer 2: (-2), (-2)*3, (-2)*3*2            <- dp[0], dp[1], dp[2]
        // layer 3: 4, 4*(-2), 4*(-2)*3, 4*(-2)*3*2
        // max stores in dp[N], min stores in dp[N+1]
        */
        
        int[] dp = new int[nums.length + 2];
        // initialize
        boolean negOneMark = false;
        
        dp[nums.length+1] = dp[nums.length] = dp[0] = nums[0];
        
        for(int layer=1; layer<nums.length; layer++){
            
            //System.out.println("[CHECK] val: " + nums[layer]);
            //System.out.print("last max: " + dp[nums.length]);
            //System.out.println(", last min: " + dp[nums.length+1]);
            
            // nums[layer] = 0
            if( nums[layer] == 0){
                int temp = dp[nums.length];
                Arrays.fill(dp,0);
                dp[nums.length] = Math.max(nums[layer],temp);
                dp[nums.length+1] = Math.min(nums[layer],temp);
                continue;
            }
            // nums[layer] = 1
            if( nums[layer] == 1){
                dp[nums.length] = Math.max(nums[layer],dp[nums.length]);
                dp[nums.length+1] = Math.min(nums[layer],dp[nums.length+1]);
                continue;
            }
            
            for(int i=layer; i>0; i--){
                dp[i] = dp[i-1] * nums[layer];
                dp[nums.length] = Math.max(dp[i],dp[nums.length]);
                dp[nums.length+1] = Math.min(dp[i],dp[nums.length+1]);
            }
            dp[0] = nums[layer];
            dp[nums.length] = Math.max(dp[0],dp[nums.length]); 
            dp[nums.length+1] = Math.min(dp[0],dp[nums.length+1]);
            
        }
             
        return dp[nums.length];
        
    }
    

}
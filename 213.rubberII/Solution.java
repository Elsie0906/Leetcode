/*
* need backtracking
*/

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
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
        
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        dp.get(0) = new ArrayList<Integer>();
        dp.get(1) = new ArrayList<Integer>();

        dp.get(0).add(nums[0]);     // acculative num of dp[0]
        dp.get(0).add(nums[0]);     // 1st item of dp[0]
        dp.get(1).add(nums[1]);     // acculative num of dp[1]
        dp.get(1).add(nums[1]);     // 1st item of dp[1]
        
        
        for(int i=2; i<nums.length-1; i++){
            idx = i%2;                          

            if( idx == 0)   // OPT(k-1) is located at dp[1]
            {
                int pVal = dp.get(1).get(0);
                int ppVal = dp.get(0).get(0);

                if( ppVal + nums[i] > pVal){
                    dp.get(0).add(nums[i]);
                    dp.get(0).set(0, ppVal + nums[i]);
                }
                else{
                    dp.get(0).copyOf(dp.get(1));
                }
            }
            else{
                // vice versa
            }
            
        }
        
        // add last node
        
        idx = (nums.length -1)%2;

        if() 
        
        return val;     // dummy
    }
    
    public void printOut(int[] dp){
        System.out.println();
        for(int i=0; i<dp.length; i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}
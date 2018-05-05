import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        // brute force
        
        int diff = Integer. MAX_VALUE;
        int ans = 0;
        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    int temp = nums[i] + nums[j] + nums[k];

                    int err = Math.abs(temp-target);
                    
                    ans = (err<diff)? temp: ans;
                    diff = (err<diff)? err: diff;
                
                }
            }
        }
        
        return ans;
        
    }
    
}
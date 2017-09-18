import java.util.*;
import java.util.Arrays;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean reVal = false;

        Arrays.sort(nums);
        
        for(int i=1; i<nums.length; i++){
            if( nums[i] == nums[i-1])
                return true;
        }
        
        return reVal;
    }
}
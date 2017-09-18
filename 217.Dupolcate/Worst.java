import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean reVal = false;
        HashMap hm = new HashMap();
        
        if( nums.length <= 1)
            return reVal;
        
        hm.put(Integer.toString(0), new Integer(nums[0]));
        
        for(int i=1; i<nums.length; i++){
            Integer temp = new Integer(nums[i]);
            if( hm.containsValue(temp) == true){
                return true;
            }      
            hm.put(Integer.toString(i), temp);
        }
        return reVal;
    }
}
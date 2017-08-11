public class Solution {
    public void sortColors(int[] nums) {
        int r_count, w_count, b_count;
        
        r_count = w_count = b_count = 0;
        
        for(int i=0; i<nums.length; i++){
            if( nums[i] == 0)
                r_count++;
            else if(nums[i] == 1)
                w_count++;
            else
                b_count++;
        }
        
        for(int i=0; i< r_count; i++)
            nums[i] = 0;
        
        for(int i=r_count; i<r_count+w_count; i++)
            nums[i] = 1;
        
        for(int i=r_count+w_count; i<nums.length; i++)
            nums[i] = 2;
            
    }
}
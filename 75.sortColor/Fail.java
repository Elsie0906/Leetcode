/*
** the sequence is not inorder....
** objects of the same color are adjacent, with the colors in the order red, white and blue.
*/
public class Solution {
    public void shift(int[] Array, int str, int end){
        
        for(int i= end; i>str; i--){
            Array[i] = Array[i-1];
            //System.out.println("check: "+ i);
        }
        
    }
    public void sortColors(int[] nums) {
        int r_str, w_str, b_str;
        
        r_str = w_str = b_str = -1;
        
        for(int i=0; i<nums.length; i++){
            
            if( r_str != -1 && nums[i] == 0 && i == r_str+1){
                r_str = i;
            }
            else if( r_str != -1 && nums[i] == 0){
                //System.out.println("str from red: "+ r_str);
                shift(nums, r_str, i);
                r_str = r_str+1;
            }
            
            if(w_str != -1 && nums[i] == 1 && i == w_str+1){
                w_str = i;
            }
            else if(w_str != -1 && nums[i] == 1){
                //System.out.println("str from white: " + w_str);
                shift(nums, w_str, i);
                w_str++;
            }
            
            if( b_str != -1 && nums[i] == 2 && i == b_str+1){
                b_str = i;
            }
            else if( b_str != -1 && nums[i] == 2){
                //System.out.println("str from white: " + b_str);
                shift(nums, b_str, i);
                b_str++;
            }

            if( r_str == -1 && nums[i] == 0)
                r_str = i;
            else if( w_str == -1 && nums[i] == 1)
                w_str = i;
            else if( b_str == -1 && nums[i] == 2)
                b_str = i;
        }
    }
}
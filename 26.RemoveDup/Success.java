import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        int count = 0;
        
        //for(int i=0; i < nums.length; i++)
        //{
        //    System.out.println("original content:" + nums[i]);
        //}        
        
        for(int i=nums.length -1; i >0; i--)
        {
            if(nums[i] == nums[i-1])
            {
                count++;
                nums[i] = 99999;
            }
        }
        
        //for(int i=0; i < nums.length; i++)
        //{
        //    System.out.println("modified content:" + nums[i]);
        //}        
        
        Arrays.sort(nums);
        
        //for(int i=0; i < nums.length; i++)
        //{
        //    System.out.println("after sorting:" + nums[i]);
        //}         
        
        //System.out.println("repeat count:" + count);
        
        result = nums.length - count;
        
        return result;
    }
}
/*
    Fail case:
    1. not in order
    2. no rechecking after a switch
*/
public class Solution {
    public int findNode(int[] a, int checkItem, int count)
    {
        int number = 0;
    
        //System.out.println("count: " + count);
    
        if(count == checkItem || a[checkItem] != a[count])
        {
            number = count;
        }
        else if(a[checkItem] == a[count] && count > checkItem)
        {
            count--;
            number = findNode(a, checkItem, count);
        }
        
        //System.out.println("return number: "+ number);
        
        return number;
        
    }
    
    public int removeDuplicates(int[] nums) {
        int temp;
        int result = 0;
        int lastNode = nums.length - 1;
        
        //System.out.println("array size: " + nums.length);
        
        for(int i=0; i< lastNode+1; i++)
        {
            
            //System.out.println("need to be compared number:" + nums[i]);
            
            for(int j=0; j<i; j++)
            {
                //System.out.println("reference number:" + nums[j]);
                
                if(nums[i] == nums[j])
                {
                   lastNode = findNode(nums, i, lastNode);
                   
                   if(lastNode == i)
                   {
                      lastNode = lastNode-1; 
                      break;
                   }
                   
                   temp = nums[lastNode];
                   //System.out.println("lastNode:" + lastNode + " content: " + nums[lastNode]);
                   nums[lastNode] = nums[i];
                   nums[i] = temp;
                   lastNode--;
                }
            }
        }
        
        //for(int i=0; i<nums.length; i++)
        //{
            //System.out.println("modified array:" + nums[i]);
        //}
        
        //System.out.println("lastNode:" + lastNode);
        
        result = lastNode+1;
        
        return result;
    }
}
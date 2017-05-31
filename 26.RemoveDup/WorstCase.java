/*
   time consuming: switching a lot
*/
public class Solution {
    public class MyClass
    {
        
        int last, repeat;
        
        public void Initiate(int LastNode, int Repeat)
        {
            last = LastNode;
            repeat = Repeat;
        }
    
        public void switching(int[] array, int first)
        {
            int temp = array[first];
        
            //System.out.println("first:" + first + ", last:" + last);
        
            for(int z=first; z<last; z++)
            {
                array[z] = array[z+1];
            }
        
            array[last] = temp;
        }
        
        public void comparing(int[] a, int checkItem, int comparedItem)
        {
        
            /* 
                comparing: 
                   if nums[i]!=nums[j]
                      keep this value
                   else
                      put it to the end of the queue
            */
            if(a[checkItem] == a[comparedItem])
            {
                repeat++;
                last = a.length - repeat;
                
                //System.out.println("repeat:" + repeat + ", Last node:" + last); 
                
                //exceptional case, ex. [1,1]
                
                if(last == checkItem)
                   return;
                
                /* switch:*/
                   
                switching(a, checkItem);
                    
                /* rechecking */
                
                if(a[checkItem] == a[comparedItem])   
                    comparing(a, checkItem, comparedItem);
                   
            }
        }        
    }
    
    public int removeDuplicates(int[] nums) {
        int result = 0;
        
        MyClass myC = new MyClass();
        
        /* CHECK: ori_len = new_len + repeat */
        
        myC.Initiate(nums.length,0);
        
        for(int i=0; i<myC.last; i++)
        {
            //System.out.println("need to be compared number:" + nums[i]);
            
            /* given a sorted array, comparing with the previous one is fine*/
            
            if( i == 0)
            {
                // do nothing
            }
            else
            {
                int j = i-1;
                //System.out.println("reference number:" + nums[j]);
            
                myC.comparing(nums, i, j);
            }
            
        }
        
        //System.out.println("repeat:" + myC.repeat + ", last node:" + myC.last);
        
        result = nums.length - myC.repeat;
        
        return result;
    }
}
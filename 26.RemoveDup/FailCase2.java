/*
    time limit exceed: too much sorting 
*/
import java.util.Arrays;

public class Solution {
    public class MyClass
    {
        int last, repeat;
        
        public void Initiate(int LastNode, int Repeat)
        {
            last = LastNode;
            repeat = Repeat;
        }
        
        public void findNode(int[] array, int first)
        {
            last = (array.length-1) - repeat;
            repeat++;
            
            System.out.println("repeat:" + repeat + ", Last node:" + last); 
            
        }
        
        public void switchNode(int[] a, int firstNode, int lastNode)
        {
            a[firstNode] = a[lastNode];
            a[lastNode] = 99999;
        }
        
        public void checkNode(int[] A, int checkItem, int comparedItem)
        {
            /* do not sort at the front of the func, time consuming!!*/
            
            if( A[checkItem] == A[comparedItem] )
            {
                /* find a node to switch*/
                    
                findNode(A, checkItem);
                    
                /* switching*/
                    
                switchNode(A, checkItem, last);

                for (int i = 0; i < A.length; i++) 
                {
                    System.out.println("before sorting: " + A[i]);
                }
                
                System.out.println("checkItem: " + checkItem + ", length of array: "+ A.length);
                
                /* OMG!! sorting for the next check, still time consuming!! OMG!!*/
                Arrays.sort(A, checkItem, last);
                
                // Print all the array elements
                for (int i = 0; i < A.length; i++) 
                {
                    System.out.println("sorting for the next check: " + A[i]);
                }
                
                /* rechecking */
                checkNode(A, checkItem, comparedItem);
            }            
        }
    }
    
    public int removeDuplicates(int[] nums) {
        int result = 0;
        
        MyClass myC = new MyClass();    
        
        myC.Initiate(nums.length,0);
        
        for(int i=0; i<myC.last; i++)
        {
            System.out.println("need to be compared number:" + nums[i]);
            
            if( i == 0)
            {
                // do nothing
            }
            else
            {
                int j = i-1;
                
                System.out.println("reference number:" + nums[j]);
                
                myC.checkNode(nums, i, j);
            }
        }
        
        // Print all the array elements
        //for (int i = 0; i < nums.length; i++) 
        //{
        //    System.out.println(nums[i] + " ");
        //}
        
        //System.out.println("repeat: " + myC.repeat);
        
        result = nums.length - myC.repeat;
        
        return result;
    }
}
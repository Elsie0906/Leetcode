public class Solution {
    public class MyClass{
        int left, right;
        boolean result;
    
        public void Initiate(int[] Array)
        {
            left = 0;
            right = Array.length -1;
            result = false;
        }
    
        public void Search(int[] array, int Target)
        {
            int midIdx = 0;
        
            while(right - left > 1)
            {
                if((left+right)%2 == 0)
                    midIdx = (left + right)/2;
                else
                    midIdx = (left + right -1)/2;
                
                //System.out.println("left index:" + left + ", right idex:" + right + ", mid idex:" + midIdx);    
            
                if(Target > array[midIdx])
                    left = midIdx;
                else if(Target < array[midIdx])
                    right = midIdx;
                else
                {
                    result = true;
                    left = midIdx;
                    right = midIdx;
                    break;
                }    
            }
        }
    }

    public int searchInsert(int[] nums, int target) {
        int Index = 0;
        MyClass myC = new MyClass();
        
        myC.Initiate(nums);
        
        //System.out.println( "The range is : 0 ~ " + (nums.length-1));
        
        myC.Search(nums, target);
        
        //System.out.println("left:" + myC.left + ", right:" + myC.right + ", result:" + myC.result); 
        
        if(myC.result == true)
            Index = myC.left;
        else if(myC.result == false && target > nums[myC.left] && target<= nums[myC.right])
            Index = myC.left+1;
        else if(myC.result == false && target > nums[myC.right])
            Index = myC.right+1;
        else if(myC.result == false && target < nums[myC.left])
            Index = myC.left;
        
        return Index;
    }
}
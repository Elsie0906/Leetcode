class Solution {
    public int findPeakElement(int[] nums) {
        int result = 0;
        
        if( nums.length == 1)
            return result;
        
        // brute force: O(n)
        boolean up = false;
        boolean down = false;
        
        if( nums[1]>nums[0])            // increasing
            up = true;
        else if( nums[1]<nums[0])       // decreasing
            down = true;
        
        int temp = 0;
        for(int i=1; i<nums.length-1; i++){
            temp = nums[i+1]-nums[i];
            if( temp<0 && up==true)
                return i;
            else if( temp>0 && down== true)
                return 0;
        }
        
        if( down==true && up==false)
            result = 0;
        else if( up==true && down==false )
            result = nums.length-1;
       
        return result;
    }
}
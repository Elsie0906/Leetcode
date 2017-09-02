class Solution {
    public int findPeakElement(int[] nums) {
        for(int i = 1; i < nums.length; i ++)
        {
            if(nums[i] < nums[i-1])
            {// <
                return i-1;
            }
        }
        return nums.length-1;
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low < high)
        {
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
}
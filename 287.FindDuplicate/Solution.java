/*
* You must not modify the array (assume the array is read only).
* You must use only constant, O(1) extra space.
* Your runtime complexity should be less than O(n2).
* There is only one duplicate number in the array, but it could be repeated more than once.
*/
class Solution {
    public int findDuplicate(int[] nums) {
        
        int val = helper(nums, 1, nums.length-1);
        
        return val; 
        
    }
    
    private int helper(int[] num, int low, int high){

        // Divide and conquer(alike binary search)
        
        if( low >= high)
            return high;
        
        int mid = low+(high-low)/2;

        int sm = 0;
        for(int i=0; i<num.length; i++){
            if( num[i] <= mid)
                sm++;
        }
        
        if( sm <= mid)    // range: mid+1 ~ high
            return helper(num, mid+1, high);
        else 
            return helper(num, 1, mid);
        
    }
}
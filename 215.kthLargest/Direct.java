class Solution {
    public int findKthLargest(int[] nums, int k) {
            
        Arrays.sort(nums);
        
        int idx = nums.length - k;
        
        return nums[idx];
    }
}
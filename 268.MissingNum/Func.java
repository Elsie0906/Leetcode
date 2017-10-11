/*
** complexity: O(n), space: O(n)
*/
class Solution {
    public int missingNumber(int[] nums) {
        int[] mark = new int[nums.length+1];
        
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            idx = nums[i];
            mark[idx] = 1;
        }
        
        // check
        for(int i=0; i<=nums.length; i++){
            if( mark[i] == 0)
                return i;
        }
        
        return 0;
    }
}
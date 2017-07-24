public class Solution {
    int find = -1;
    public void biSearch(int[] Array, int goal, int strIdx, int endIdx){
        int mid = 0;
        
        //System.out.println("start: " + strIdx + ", end: " + endIdx + ", find: " + find);
        
        int len = endIdx - strIdx + 1;
        
        if( len%2 == 1)
            mid = (strIdx + endIdx)/2;
        else
            mid = (strIdx+ endIdx -1)/2;
        
        if( Array[mid] != goal){
            if((endIdx == strIdx + 1) && (mid+1) <= endIdx && Array[mid+1] != goal)
            {
                //System.out.println("cannot find it!");
                return;                
            }
            else if( (endIdx == strIdx + 1) && (mid + 1 <= endIdx) && Array[mid+1] == goal){
                find = mid + 1;
            }
            else if( Array[mid] > goal){
                endIdx = mid;
                biSearch(Array, goal, strIdx, endIdx);               
            }
            else if(Array[mid] < goal){
                strIdx = mid;
                biSearch(Array, goal, strIdx, endIdx);                
            }
            
        }
        else{
            //System.out.println("find it!!" + mid);
            find = mid;
        }       
       
        return;
    }
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int left, right;
        int[] result = new int[2];
        result[0] = left = -1;
        result[1] = right = -1;
        
        if( nums.length == 0) return result;
        
        if( nums.length == 1 && nums[0] != target) return result;
        
        // Initialize: searching range 0 ~ (num.length-1)
        biSearch(nums, target, start, end);
        //System.out.println("find: " + find);
        
        if( find == -1)
            return result;
        else{
            left = right = find;
        }
            
        while( left>0 && nums[left-1] == target){
            left = left -1;
        }
        
        while( right<nums.length-1 && nums[right+1] == target){
            right = right + 1;
        }
        
        //System.out.println("left: " + left + ", right: " + right);

        result[0] = left;
        result[1] = right;
        
        return result;
    }
}
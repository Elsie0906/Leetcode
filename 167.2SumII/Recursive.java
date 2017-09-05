class Solution {
    private int[] result = new int[2];
    private int idx1 = 0;
    private int idx2 = 0;
    public int twoSumNext(int[] nums, int strIdx, int goal){
        int val = -1;
        
        //System.out.println("strIdx: "+ strIdx + ", goal: " + goal);
        
        if( strIdx < nums.length && goal == nums[strIdx]){
            idx2 = strIdx;
            return 1;
        }
        
        if( strIdx < nums.length && goal != nums[strIdx]){
            strIdx++;
            val = twoSumNext(nums, strIdx, goal);
        }
                 
        return val;
                
    }
    public int[] twoSum(int[] numbers, int target) {
        int control = -1;
        
        // recursive
        
        for(int i=0; i<numbers.length; i++){
            //System.out.println("idx1: "+ idx1 + ", target: " + target);
            idx1 = i; 
            
            if( i+1<numbers.length && numbers[i] == 0 && target != 0)
                continue;
            
            control = twoSumNext(numbers, i+1, target - numbers[i]);
            if( control == 1)
                break;
        }
        
        result[0] = idx1 + 1;
        result[1] = idx2 + 1;
        
        return result;
    }
}
/*
** Recursive: time-wasting!!
*/
class Solution {
    public int maxMoney(int[] Array, int number){
        
        if( number == 0)
            return Array[number];  
        
        if( number == 1)
            return Math.max(maxMoney(Array, 0), Array[number]);
        

        return Math.max(maxMoney(Array, number-1), maxMoney(Array, number-2)+Array[number]); 
        
    }
    
    public int rob(int[] nums) {
        
        if( nums.length == 0)
            return 0;
        
        return maxMoney(nums, nums.length-1);
    }
}
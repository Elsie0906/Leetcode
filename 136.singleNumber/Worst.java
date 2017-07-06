public class Solution {
    public boolean Find(int check, int[] searchArray, int searchRange){
        boolean checkResult = false;
        
        for(int j=0; j< searchRange; j++){
            
            if(check == searchArray[j]){
                checkResult = true;
                searchArray[j] = 0xffff;                
            }
        }
        
        return checkResult;
    }
    public int singleNumber(int[] nums) {   
        int[] storage = new int[nums.length];
        int count = 0;
        int find = 0;
        
        for(int i=0; i<nums.length; i++){
            
            if( i == 0 ){
                storage[count] = nums[i];
            }
            
            boolean result = Find(nums[i], storage, count ); 
            
            if( result == false){
                storage[count] = nums[i];
                count++;
            }    
        }
        
        for(int z=0; z<count; z++){
            if(storage[z] != 0xffff){
                find = storage[z];
                break;
            } 
        }
        
        return find;
    }
}
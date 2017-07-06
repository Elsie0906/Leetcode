import java.util.Arrays;

public class Solution {
    public class MyClass{
        int find;
        int index;
        
        public void Initiate(){
            find = 0;
            index = 0;
        }
        
        public void FindNum(int[] searchArray){
            
            find = searchArray[searchArray.length-1];
            
            if( index < searchArray.length-1){
                if( searchArray[index] == searchArray[index+1]){
                    index = index +2;
                    FindNum(searchArray);
                }
                else{
                    find = searchArray[index];
                    return;
                }                
            }
        }
    }
    public int singleNumber(int[] nums) {
        //System.out.println("size of array " + nums.length);
        
        if( nums.length == 0)
            return 0;
        
        if( nums.length == 1)
            return nums[0];
        
        // 1. sorting -> for second phase
        Arrays.sort(nums);
        
        // 2. find the non-redudant one
        MyClass myC = new MyClass();
        myC.Initiate();
        myC.FindNum( nums );
        
        //System.out.println("find number: " + myC.find);
        
        return myC.find;
    }
}
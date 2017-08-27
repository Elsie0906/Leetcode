/*
** How many trailing zeroes do we have ? = How many '10' do we have? = How many '5' do we have? 
*/
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        int temp = n;
        
        do{      
            count = count + temp/5;
            //System.out.println("control : "+ temp + ", count: " + count);
            
            temp = temp/5;
            
        }while(temp > 0); 
        
        return count;
    }
}
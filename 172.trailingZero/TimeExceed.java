/*
** How many trailing zeroes do we have ? = How many '10' do we have? = How many '5' do we have? 
*/
class Solution {
    int count = 0;
/*    
    public void checkFive(int num){
        int temp = num;
        
        if( num == 0 )
            return;
        
        while( temp%5 == 0){
            count++;
            temp = temp/5;
        }
        //System.out.println("num: "+ num+", count '5' : "+ count);
        checkFive(num-1);
        
    }
*/
    public void checkFive(int num){
        int temp = 0;
        
        if( num < 5)
            return;
        
        for(int i=5; i<= num; i = i+5){
            temp = i;
            
            while( temp%5 == 0){
                count++;
                temp = temp/5;
            }            
            //System.out.println("num: "+ i +", count '5' : "+ count);
        }
        
    }
    public int trailingZeroes(int n) {
        int result = 0;
        
        if( n == 0 )
            return result;
        
        checkFive(n);
        
        //System.out.println("count '5' : "+ count);
        
        return count;
    }
}
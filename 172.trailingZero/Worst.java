/*
** How many trailing zeroes do we have ? = How many '10' do we have? = How many '5' do we have? 
*/
class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        int power = 1;
        int divisor = (int) Math.pow(5, power);
        int count = 0;
        int dividend = n;
        int temp = dividend - (dividend%divisor);
        
        if( n<5)
            return result;
        
        while( temp > 5){
            //System.out.println("control : "+ temp);
            
            divisor = (int) Math.pow(5, power);
            count = count + (dividend/divisor -1);
            //System.out.println("divisor : "+ divisor + ", count: " + count);
            power++;
            
            temp = temp/5;
        }
        
        //System.out.println("temp : "+ temp + ", power" + power);
        
        divisor = (int) Math.pow(5, power);
        
        if( temp%5 == 0){
            count = count + power;
        }
        else{
            divisor = (int) Math.pow(5, power-1);
            count = count + power -1;
        }

        //System.out.println("divisor: "+divisor+", count : "+ count);
        
        return count;
    }
}
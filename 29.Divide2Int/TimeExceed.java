import java.math.BigInteger;

public class Solution {
    
    public boolean checkOverflow(long number){
        boolean overflow = false;
        
        if( number > 0 && number > Integer.MAX_VALUE)
            overflow = true;
        if( number < 0 && number < Integer.MIN_VALUE)
            overflow = true;
        
        //System.out.println("check overflow: " + overflow + ", number: " + number);
        
        return overflow;
    }
    public long Abs(int num){
        
        if( num > 0)
            return (long) num;
        else
            return (long) num*(-1);
        
    }
    public int divide(int dividend, int divisor) {
        int result = 0;
        
        /*
        ** Special case: divisor = 0
        ** Overflow: dividend = -2147483648
        */
        
        if( divisor == 0 ) return Integer.MAX_VALUE;

        /*
        ** Special case: divisor = 1 or -1
        */
        
        boolean mark = false;
        
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) mark = true;
       
        //System.out.println("check: " + Math.abs(divisor) + " , " +  mark);
        
        long x = Abs(dividend);
        long y = Abs(divisor);
        
        if(y == 1){
            if( mark == false && checkOverflow(x) == true)
                return Integer.MAX_VALUE;
            else if(mark == true && checkOverflow(0-x) == true)
                return Integer.MAX_VALUE;
            else if(mark == false && checkOverflow(x) == false)
                return (int)x;
            else if(mark == true && checkOverflow(0-x) == false)
                return (int)(0-x);            
        }

        /*
        ** 5 / 12 return 0
           1 / -5 return 0
        */
               
        if(x < y) return result;
        
        /*
        ** Special case: divisor = 2 or -2
        */

        if( y == 2){
            long z = (long)(Abs(dividend) >> 1);
            
            //System.out.println("check: " + z + " , " +  mark);
            
            if( mark == false && checkOverflow(z) == true)
                return Integer.MAX_VALUE;
            else if( mark == true && checkOverflow(0-z) == true)
                return Integer.MAX_VALUE;
            else if( mark == false && checkOverflow(z) == false)
                return (int)z;
            else if(mark == true && checkOverflow(0-z) == false)
                return (int)(0-z);
        }
                    

        /*
        ** Need to take care of non-positive number 
        */

        
        int count = 0;
        
        while(x >= y){
            x = x - y;
            count++;
            
            //System.out.println( "dividend: " + mod_dividend + ", divisor: " + mod_divisor + ", count: " + count);
        }
        
        if( mark == true)
            result = 0 - count;
        else
            result = count;
        
        return result;
    }
}
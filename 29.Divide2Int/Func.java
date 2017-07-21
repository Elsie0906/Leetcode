import java.math.BigInteger;

public class Solution {
    public int multiply10(int num){
        
        int cal = (num << 3) + (num << 1); 
        
        //System.out.println("num: " + num + " x 10 = " + cal);
        
        return cal;
    }
    public int[] Divide(int Dividend, int Divisor){
        int Quotient = 0;
        int Remainder = 0;
        int a1 = Dividend;
        int a2 = Divisor;
        int[] valA = new int[2];
        
        while(a1 >= a2){
            a1 = a1 - a2;
            Quotient++;
        }
        
        Remainder = a1;
        //System.out.println( "dividend: " + Dividend + ", divisor: " + Divisor + ", Q: " + Quotient + ", R: " + Remainder);
        
        valA[0] = Quotient;
        valA[1] = Remainder;
        
        return valA;
    }
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
        
        String val = Integer.toString(dividend);
        
        //System.out.println("Original content = " + val + " len: " + val.length());
        //System.out.println("value = " + Character.getNumericValue(val.charAt(0)));  
        
        // when Character.getNumericValue(val.charAt(0)) = -1, which means dividend < 0
        if( Character.getNumericValue(val.charAt(0)) == -1){
            val = val.replace('-', '0');
            //System.out.println("modified: " + val + " len: " + val.length());
        }  
        
        // Deal with negative number //
        
        boolean mark = false;
        
        if( (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) mark = true;           

        // Special case: overflow //
        /*
        ** -2147483648 / -1
        */
        
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
        
        // Special case: overflow //
        /*
        ** -2147483648 / -1017100424
        */
        
        if( dividend == -2147483648 && divisor < -214748364){
            int special = 0;
            while(dividend <= divisor){
                //System.out.println( "dividend: " + dividend + ", divisor: " + divisor);
                dividend = dividend - divisor;
                special++;
            }
            return special;
        }
        else if(dividend == -2147483648 && divisor > 214748364){
            int special = 0;
            while(dividend <= -divisor){
                //System.out.println( "dividend: " + dividend + ", divisor: " + divisor);
                dividend = dividend + divisor;
                special++;
            }
            return -special;
        }

        /*
        ** 5 / 12 return 0
           1 / -5 return 0
        */        
               
        if(x < y){
          //System.out.println("check: x " + x + " y " + y);  
          return result;  
        } 
       
        // positive number //
       
        divisor = Math.abs(divisor);
        
        int[] cal = new int[val.length()];
        int number = 0;
        int cal_num = 0;
        int[] rVal = new int[2]; 

        for( int i=0; i<val.length(); i++){

            number = Character.getNumericValue(val.charAt(i));
            cal_num = cal_num + number;
            //System.out.println("check = " + number + ", cal_num: " + cal_num);
            
            if( cal_num < divisor){
                cal_num = multiply10(cal_num); 
                cal[i] = 0;
            } 
            else{
                //cal_num = cal_num + number;
                rVal = Divide(cal_num, divisor);
                cal[i] = rVal[0];
                cal_num = rVal[1];
                
                if( i != val.length()-1)
                    cal_num = multiply10(cal_num);
                
            }
            
        }

        int Q = 0;
        
        for(int j=0; j< cal.length; j++){
            //System.out.println("cal = " + cal[j]);
            Q = multiply10(Q) + cal[j];
        }
        
        if( mark == true)
            result = 0-Q;
        else
            result = Q;

        
        return result;
    }
}
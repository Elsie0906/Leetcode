public class Solution {
    public double myPow(double x, int n) {
        double result = 0;
        
        //System.out.println("x: " + x + ", n: " + n);
        
        if( n == 0 ) return 1; // 2^0 = 1
        if( n == 1 ) return x; // 2^1 = 2
        if( x == 0 ) return 0; // 0^1 = 0
        if( x == 1 ) return 1; // 1^2 = 1
        
        // x < 0, ex. (-1)^2147483647
        
        //System.out.println("special case: " + (-2147483647%2));
        
        if( x<0 && Math.abs(n)%2 == 1){
            result = (-1)*myPow(-x,n);
            return result;
        }else if( x<0 && Math.abs(n)%2 == 0){
            result = myPow(-x,n);
            return result;
        }
            
        
        // double range: 15 significant decimal digits
        // 2^N < 10^15, N < 50
        
        // 0<x<1, ex. 0.00001^2147483647 or 0.99999^948688
        
        if( x >= 2 && (n > 50 || n < -50)) return 0.0;
        
        if( x > 0 && x < 0.5){
            result = myPow(10*x,n)*myPow(10,-n);
            return result;
        }
        
        // int range: -2,147,483,648 to 2,147,483, 647
        // ex. 2.00^-2147483648
        if( n<0 && n<=Integer.MIN_VALUE){
            result = myPow(x,n+Integer.MAX_VALUE)*myPow(x,Integer.MIN_VALUE+1);
            return result;
        }
            
        
        if( n<0)
            result = 1/myPow(x,-n);
        
        if( n > 0 && n%2 == 1) 
            result = myPow(x, 1)*myPow(x, n-1);
        if( n > 0 && n%2 == 0)
            result = myPow(x, n/2)*myPow(x,n/2); 
        
        return result;
    }
}
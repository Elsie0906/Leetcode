/*
** Top-Down search: recursive
*/
class Solution {
    public int numSquares(int n) {
        // How may square num you may use?
        
        int square = (int)Math.sqrt(n);
        //System.out.println("Math.sqrt(" +  n+ ")=" + square);
        
        int reVal = helper(n,square);
        
        //System.out.println("Min=" + reVal);
        
        return reVal;
    }
    
    public int helper(int n, int square){

        int value = square * square;
        
        //System.out.println("num=" + n + " value: " + square);
        
        if( n == 0)
            return 0;
        
        if( square == 1)
            return n;
        
        if( value > n){
            square--;
            return helper(n, square);
        }
            
        
        int count = n/value;
        int rem = n%value;
        square--;
        
        //System.out.println("count: " + count);
        
        return Math.min(count+helper(rem,square),helper(n, square));
    }
}
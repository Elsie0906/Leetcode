/*
    Find the rule: f(n) = f(n-1) + 1 or f(n) = f(n-2) + 2
    Enumerate:
    f(0) = 0
    f(1) = 1                              <- 1 way
    f(2) = f(1) + 1 or f(2) = f(0) + 2    <- 2 ways
    f(3) = f(2) + 1 or f(3) = f(1) + 2    <- 2 + 1 = 3 ways
    f(4) = f(3) + 1 or f(4) = f(2) + 2    <- 3 + 2 = 5 ways
    ....
    sequence: 1,2,3,5,8,...
*/
public class Solution {
    public int F(int x)
    {
        // initialize
        if( x==0 || x==1 || x==2)
            return x;        
        else    
            return (F(x-1) + F(x-2));
    }
    public int climbStairs(int n) {
        int result = 0;
        
        //result = F(n);
        
        for(int i=0; i<44; i++)
            System.out.println("i= "+ i + ", result:" + F(i));
        
        return result;
            
        
    }
}
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
/* WARNING: Do not use recursive call! It is time-consuming! Using for loop instead!!!! */

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
        int[] A = new int[2];
        int temp1 = 0;
        int temp2 = 0;
        int result = 0;
        
        //Initialize
        A[0] = 1;
        A[1] = 2;
        
        if( n==0 || n==1 || n==2)
            return n;
        
        for(int i=3; i<=n; i++)
        {
            temp2 = A[0] + A[1];
            temp1 = A[1];
            A[0] = temp1;
            A[1] = temp2;
            
            //System.out.println("i= "+ i + ", result:" + temp2);
        }

        result = temp2;
        
        return result;
            
        
    }
}
/*
    Easy case, return integer number
    Input range(for java): -2,147,483,648 to 2,147,483,647
    max input: 2147483647
    max output: 46340
    brute force: add one by one
    estimate first: if x's sqrt is abcde = a*10^4 + b*10^3 + c*10^2 + d*10 + e
    example:
            Input: 13, Output:3
            
*/
public class Solution {
    public void Initiate(int[] y){
        
        for(int k=0; k<y.length; k++)
        {
            y[k] = 0;
        }
    }
    public int Calculate(int[] z){
        int result = 0;
        //int base = (int) Math.pow(10,4);
        
        result = z[0]*(int)Math.pow(10,4) + z[1]*(int)Math.pow(10,3) + z[2]*(int)Math.pow(10,2) + z[3]*(int)Math.pow(10,1);
        result = result + z[4];
        /*
        for(int h=0; h<z.length; h++){
            base = (int)Math.pow(10,4-h);
            result = result + z[h]* base;
            //System.out.println("h: " + z[h] + ", base: " + base);
        }
        */
        //System.out.println("Array: " + result);
        
        return result;
    }
    public int mySqrt(int x) {
        int root = 0;
        int[] IntA = new int[5]; // max output: 46340.9
        int start = 0;
        long cal = 0;
        int temp = 0;
        int i;
        
        //System.out.println("max output: " + Math.sqrt(2147483647));
        
        Initiate( IntA );
        
        for(int j=0; j<IntA.length; j++)
        {
            start = (int)Math.pow(10,4-j);
          
            //System.out.println("start: " + start);  
            
            for(i=0; i<10; i++)
            {
                temp = Calculate( IntA );
                cal = (long)(temp + i* start)*( temp + i*start);
                //System.out.println("i: " + i + ", cal: " + cal + ", x: " + x); 
                if( cal > (long)x)
                {
                    //System.out.println("Approach i: " + i); 
                    IntA[j] = i-1;
                    break;
                }
                
                if( cal == (long) x)
                {
                    //System.out.println("Find i: " + i);
                    IntA[j] = i;
                    break;
                }
        
                if( (cal < (long)x) && i==9) // exceptional case, ex. 8192
                {
                    //System.out.println("default i: " + i);
                    IntA[j] = 9;
                }
            }
        }
        
        root = Calculate( IntA );
        
        return root;
    }
}
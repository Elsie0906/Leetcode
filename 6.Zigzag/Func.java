/* 
    N: numRows
    1st row: 0 -> 2N-2 -> ... (one addend: a0 = 2N-2)
    2nd row: 1 -> 2N-3 -> 2N-1 -> ...(two addend: a1 + a2 = a0, a1 = 2, a2 = 2N-4)
    3rd row: 2 -> 2N-4 -> 2N -> ...(two addend: a1 + a2 = a0, a1 = 4, a2 = 2N-6)
    N-1 row: N-1 -> 3(N-1) -> ...
*/
import java.io.*;
public class Solution {
    public String convert(String s, int numRows) {
        char[] Sarray = new char[s.length()];
        int a0 = 2*numRows-2;
        int a1, a2;
        int count = 0;
        int index = 0;

        //System.out.println("string len: " + s.length() + ", char array len: " + Sarray.length);
        
        /* exceptional case: "A" or "AB" for numRows = 1 */
        if( s.length() <= numRows || numRows == 1)
            return s;

        // 1st row
        while( count*a0 < s.length())
        {
            Sarray[count] = s.charAt(count * a0);
            count ++;
        }

        //System.out.println("count: " + count);
        int pre_count = count;
        
        // other rows
        for(int i=1; i< numRows-1 ; i++)
        {
            a1 = i*2;
            a2 = a0 - a1;
            index = i;
            count = 0;
            
            //System.out.println("a1: " + a1 + ", a2: " + a2); 

            while( index < s.length())
            {
                //System.out.println("index: " + index);
                
                Sarray[pre_count] = s.charAt(index);
                pre_count ++;
                count ++;
                if( count % 2 == 0)
                    index = index + a1; 
                else
                    index = index + a2;

            }
        }
        
        // last row
        count = 0;
        
        while ( (numRows-1) + count * a0 < s.length() )
        {
            Sarray[pre_count] = s.charAt( numRows-1 + count * a0 );
            pre_count ++;
            count ++;
        } 
        
        String ans = new String(Sarray);
        //System.out.println(ans);
        
        return ans;
    }
}
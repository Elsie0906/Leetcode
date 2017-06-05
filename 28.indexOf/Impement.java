import java.io.*;
public class Solution {
    public int strStr(String haystack, String needle) {
        int index = -1;
        
        //System.out.println( needle );
        //System.out.println(needle.substring(0, 5) );
        //System.out.println( "String Length is : " + needle.length() );
        
        char[] oriArray = haystack.toCharArray();
        char[] checkArray = needle.toCharArray();
        
        for(int i=0; i<= (oriArray.length - checkArray.length); i++)
        {
            /* exceptional case: haystack = "a", needle = "" */
            if(checkArray.length == 0)
            {
                index = 0;
                break;
            }
            
            if(checkArray.length!=0 && oriArray[i] == checkArray[0])
            {
                String str1 = "";
                
                str1 = str1.copyValueOf( oriArray, i, checkArray.length );
                //System.out.println("str1: " + str1);
                //System.out.println("str2: " + needle);
                    
                int result = str1.compareTo( needle );
                if(result == 0)
                {
                    index = i;
                    break;
                }
            }
            
        }
        
        return index;
    }
}
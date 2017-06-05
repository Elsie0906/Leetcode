import java.io.*;
public class Solution {
    public int strStr(String haystack, String needle) {
        int index = -1;
        
        //System.out.println( needle );
        //System.out.println( "String Length is : " + needle.length() );
        
        index = haystack.indexOf( needle );
        //System.out.println("Found Index :" + haystack.indexOf( needle ));
        
        return index;
    }
}
/*
    Normal case: "Welcome to New York"
    Exceptional case: "a "
    Fail case: "b  a  "
    WARNING: Do not try to use tricky way! You need to parse every single char by yourself
*/
public class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        
        //System.out.println( "original string: " + s );
        //System.out.println( "string length: " + s.length() );
        //System.out.println("Find first index of spare space: " + s.indexOf( ' ' ));
        //System.out.println("Find last index of spare space: " + s.lastIndexOf( ' ' ));
        
        boolean retVal;

        retVal = s.endsWith( " " );
        //System.out.println("Returned Value = " + retVal );   
        
        if(retVal == true)
        {
            String newS = s.substring(0, s.length()-1);
            //System.out.println(s.substring(0, s.length()-1) );
            //System.out.println("Find last index of spare space: " + newS.lastIndexOf( ' ' ));
            
            if(newS.lastIndexOf(' ') == -1)
                return newS.length();
            else    
                return newS.length() - 1 - newS.lastIndexOf(' ');
        }
        
        result = s.length() - 1 - s.lastIndexOf(' ');
        
        return result;
    }
}
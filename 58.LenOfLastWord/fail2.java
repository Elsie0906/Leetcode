/*
    Normal case: "Welcome to New York"
    Exceptional case: "a "
    Fail case: "b  a  "
    WARNING: Do not try to use tricky way! You need to parse every single char by yourself
    Do not count based on spare space, ex. "b  abc  "
*/
public class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        int[] IndexA = new int[s.length()];
        int index = 0;
        //int count = 0;
        
        System.out.println( "original string: " + s );
        System.out.println( "string length: " + s.length() );
        //System.out.println("Find first index of spare space: " + s.indexOf( ' ' ));
        //System.out.println("Find last index of spare space: " + s.lastIndexOf( ' ' ));
        
        for(int i=0; i<s.length(); i++){
            if( s.charAt(i) == ' ')
            {
                System.out.println( "Find spare space: " + i );
                IndexA[index] = i;
                index++;
            }
        }
        
        if( index == 0) // no spare space
            result = s.length();
        else if( index == 1 && IndexA[0] == s.length()-1) // only one spare space and the string ends with spare space
            result = s.length() -1;
        else if( index == 1 )
            result = s.length() -1 -IndexA[0];
        else
            result = IndexA[index-1] - IndexA[index-2];
        
        return result;
    }
}
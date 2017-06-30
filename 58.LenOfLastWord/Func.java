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
        int count = 0;
        
        for(int i=0; i<s.length(); i++){
            
            if( i==s.length()-1 && s.charAt(i) != ' ' ) // ex. " day"
            {
                //System.out.println( "ends of valid char" );
                IndexA[index] = count+1;
                index++;
                count = 0;
            }  
            else if( s.charAt(i) != ' ')
            {
                //System.out.println( "Find valid char: " + i );
                count++;
            }     
            else if( count == 0 && s.charAt(i) == ' ') // ex." a"
            {
                // SKIP!!
            } 
            else if( i != 0 && s.charAt(i-1) == ' ') // ex. "b  abc  "
            {
                //SKIP!! Do nothing
            }             
            else if( s.charAt(i) == ' ' ) // ex. "a b "
            {
                //System.out.println( "Find spare space: " + i + ", series count: " + count);
                IndexA[index] = count;
                index++;
                count = 0;
            }            
        }
        
        //System.out.println( "check value: " + count + ", index: " + index);
        if( index == 0) // ex. " "
        {
            return count;
        }
        
        //for(int j=0; j<s.length(); j++)
        //{
        //    System.out.println( "count: " + IndexA[j] );
        //}
        
        result = IndexA[index-1];
        
        return result;
    }
}
public class Solution {
    public boolean isPalindrome(String testS) {
        boolean result = false;
        int arrLen = testS.length();
        char[] charArray = new char[arrLen];
    
        //System.out.println( "String: " + testS + ", len: " + testS.length() );
        
        /*  'a' is a palindrome !!!(why??)
        if( testS.length() == 1 )
            return false;
        */
        
        //1. reverse the string
        
        //System.out.println( "create a char array, len: " + charArray.length );
        
        for(int i=0; i<charArray.length; i++)
        {
            charArray[i] = testS.charAt(arrLen -1 -i);
            //System.out.println( "content: " + charArray[i] );
        }
        
        String reverseString = new String(charArray);
        
        //System.out.println( "reverse string: " + reverseString );
        
        //2. check if string is Palindrome

        int tempResult = testS.compareTo( reverseString );
        //System.out.println("compare result: " + tempResult);
        
        if( tempResult == 0)
            result = true;
        
        return result;
    }
    public String longestPalindrome(String s) {
        Solution sol = new Solution();
        boolean check = false;
        String ans = "";
        String subS;
        int startIdx = 0;
        int endIdx;
        int chosenIdx = 0;
        int stringIdx = 0;
        int len = 0;
        int maxLen = 0;
        int max = 1000;
        String[] candidate = new String[max];        
        
        while( startIdx != s.length())
        {
            endIdx = s.length();
         
            //System.out.println("start index: " + startIdx + ", end index: " + endIdx );
            
            while( endIdx != startIdx )
            {
                //System.out.println( s.subSequence(startIdx, endIdx));
                subS = (String) s.subSequence(startIdx, endIdx);
                check = sol.isPalindrome( subS );
                //System.out.println("isPalindrome: " + check);     
                
                if( check == true)
                {
                    len = subS.length();
                    candidate[stringIdx] = subS;  
                    //System.out.println("candidate: " + subS); 
                    
                    if(len > maxLen)
                    {
                        maxLen = len;
                        chosenIdx = stringIdx;
                    }
                    
                    stringIdx++;
                }
                    
                endIdx--;
            }            
            startIdx++;
        }
        
        //System.out.println("chosenIdx " + chosenIdx + ", content: " + candidate[chosenIdx]); 
        
        ans = candidate[chosenIdx];
        
        return ans;
        
    }
}
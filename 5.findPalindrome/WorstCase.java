public class Solution {
    public boolean isPalindrome( String testS, int start, int end ) {
        boolean result = true;
        int midIdx = 0;    
        int len = 0;
        int interval = 0;
        
        len = end - start + 1;
        
        if( len % 2 == 1 )
            interval = (len + 1) /2;
        else
            interval = len/2;
            
        //System.out.println( "interval: " + interval + ", startIdx: " + start + ", endIdx: " + end);    
        
        for(int i= 0; i<interval; i++)
        {
            //System.out.println( "comparing: " + testS.charAt(start + i) + " vs " + testS.charAt(end - i)); 
            if( testS.charAt(start+i) != testS.charAt(end -i ) )
                return false;
        }
        
        return result;
    }
    public String longestPalindrome(String s) {
        Solution sol = new Solution();
        boolean check = false;
        int startIdx = 0;
        int endIdx;
        int chosenIdx = 0;
        int len = 0;
        int maxLen = 0;
        String ans = "";

        int count = s.length();
        
        //System.out.println("count: " + count ); 
        
        if( count == 1)
            return s;
        
        while(count > 1)
        {
            
            for(startIdx=0; startIdx < s.length(); startIdx++)
            {
                endIdx = startIdx + count - 1;
    
                //System.out.println("start index: " + startIdx + ", end index: " + endIdx ); 
                
                if( endIdx >= s.length())
                    break;
                    
                check = sol.isPalindrome( s, startIdx, endIdx );
                    
                //System.out.println("isPalindrome: " + check);     
            
                if( check == true){
                    return s.substring(startIdx, endIdx+1);
                }
            }
            
            count--;
            
        }

        ans = s.substring(0,1);
        //System.out.println(" string content: " + ans);         
       
        return ans;
        
    }
}
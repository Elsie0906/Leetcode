class Solution {
    private int[] canonical = new int[128];     // using canonical form, 128 characters, ASCII
    private int oddPos = -1;
    
    public List<String> generatePalindromes(String s) {
        List<String> list = new ArrayList<String>();
        
        canonical(s);
        
        boolean reVal = canPalindromes();        
        if( reVal == false)
            return list;
        
        
        
    }
    private void canonical(String s){           // calculate num of each char
        
        for(int i=0; i<s.length(); i++){
            int idx = (int)s.charAt(i);       
            //System.out.println("[Debug]:idx " + idx);
            canonical[idx]++;                   // special case:"AaBb//a"
        }        
    }
    private boolean canPalindromes(){           // check each num in array "canonical"
      
        boolean odd = false;
        
        for(int i=0; i<canonical.length; i++){
            int val = canonical[i];
            if( val != 0 && !odd && val%2==1){
                odd = true;
                oddPos = i;
            }
            else if( val != 0 && val%2 == 1 && odd){
                return false;
            }
        }
        
        return true;
    }
}
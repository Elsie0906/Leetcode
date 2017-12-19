class Solution {
    public boolean canPermutePalindrome(String s) {
        // using canonical form, 128 characters, ASCII
        int[] canonical = new int[128];
        
        // calculate num of each char
        for(int i=0; i<s.length(); i++){
            int idx = (int)s.charAt(i);       
            //System.out.println("[Debug]:idx " + idx);
            canonical[idx]++;               // special case:"AaBb//a"
        }
        
        // check each num in array "canonical"
        boolean odd = false;
        for(int i=0; i<canonical.length; i++){
            int val = canonical[i];
            if( val != 0 && !odd && val%2==1){
                odd = true;
            }
            else if( val != 0 && val%2 == 1 && odd){
                return false;
            }
        }
        
        return true;
        
    }
}
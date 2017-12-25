/*
* You may assume both s and t have the same length
* Using two HashMap to check if it is one-on-one mapping
*/

class Solution {
    
    private HashMap<Character,Character> hm = new HashMap<>();
    private HashMap<Character,Character> hmR = new HashMap<>();
    
    public boolean isIsomorphic(String s, String t) {
        boolean reVal = true;
        
        for(int i=0; i<s.length(); i++){        
            char key = s.charAt(i);
            char val = t.charAt(i);
            
            if(!hm.containsKey(key)){
                if( hmR.containsKey(val) && hmR.get(val) != key)
                    return false;
                
                hm.put(key, val);           // s to t
                hmR.put(val, key);          // t to s                
            }
            else{
                if( hm.get(key) != val)
                    return false;
            }
        }
             
        return reVal;
    }
}
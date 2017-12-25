/*
* You may assume both s and t have the same length
* Using two HashMap to check if it is one-on-one mapping
*/

class Solution {
    
    private HashMap<Character,Character> hm = new HashMap<>();
    private HashSet<Character> hs = new HashSet<>();
    
    public boolean isIsomorphic(String s, String t) {
        boolean reVal = true;
        
        for(int i=0; i<s.length(); i++){        // s to t
            char key = s.charAt(i);
            char val = t.charAt(i);
            if( !hm.containsKey(key)){
                hm.put(key, val);
            }
            else{
                char compare = hm.get(key);
                if( compare != val)
                    return false;
            }
        }
        
        Set set = hm.entrySet();                // t to s, value should be unique
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            char key = (char)me.getValue();
            if( !hs.contains(key)){
                hs.add(key);
            }
            else
                return false;
        }         
        
        return reVal;
    }
}
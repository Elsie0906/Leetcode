/*
* s = "aba"
* t = "baa"
*/

class Solution {
    
    private int[] canonical = new int[128];
    private int[] compare = new int[128];
    
    HashMap<Integer,Integer> hm = new HashMap<>();
    
    public boolean isIsomorphic(String s, String t) {
        // step1: canonical form
        init(s,t);
        prepare();
        deBug();        
        return compare();
        
    }
    private void deBug(){
        Set set = hm.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }        
    }
    private boolean compare(){
        for(int i=0; i<compare.length; i++){
            int key = compare[i];
            if( key == 0)
                continue;
            
            if(!hm.containsKey(key)){
                return false;
            }
            else{
                int val = hm.get(key);
                val--;
                hm.put(key,val);
            }          
        }
        
        Set set = hm.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            int val = (int)me.getValue();
            if( val != 0)
                return false;
        }
        
        return true;
    }
    private void prepare(){
        for(int i=0; i<compare.length; i++){
            int key = canonical[i];
            if( key == 0)
                continue;
            
            if(!hm.containsKey(key)){
                hm.put(key,1);
            }
            else{
                int val = hm.get(key);
                val++;
                hm.put(key,val);
            }          
        }
    }
    private void init(String s, String t){
        // You may assume both s and t have the same length
        int idxS = -1, idxT = -1;
        for(int i=0; i<s.length(); i++){
            idxS = (int)s.charAt(i);
            idxT = (int)t.charAt(i);
            /*
            if( idxS >= 128 || idxS<0 || idxT>=128 || idxT<0){
                System.out.println(idxS + " " + idxT);
                break;
            }
            */    
            canonical[idxS]++;
            compare[idxT]++;
        }
    }
}
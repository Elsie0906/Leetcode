/*
* failed case: ["ab","ba"]
* contains only lowercase alphabets
*/

class Solution {
    // hashcode: len << 3 + diff
    // <hashcode, idx>
    private HashMap<Integer, Integer> hm = new HashMap<>();
    
    public List<List<String>> groupStrings(String[] strings) {
        
        List<List<String>> arrList = new ArrayList<>();
        
        int idx = 0, len = -1, diff = -1, hashcode = -1;
        
        //System.out.println("<<" + (strings.length << 2));
        
        for(int i=0; i<strings.length; i++){
            
            len = strings[i].length();          
            diff = calculate(strings[i]);
            //System.out.println("[Debug] len: " + len + ", diff: " + diff);
            hashcode = (len * 100) + diff;
            
            if( !hm.containsKey(hashcode) ){                        // <hashcode,idx>
                List<String> list = new ArrayList<>();
                list.add(strings[i]);
                arrList.add(list);
                hm.put(hashcode, idx);                              // update
                idx++;
            }
            else{
                int index = hm.get(hashcode);
                List<String> list = arrList.remove(index);
                list.add(strings[i]);
                arrList.add(index, list);
            }
        }
        
        return arrList;     // dummy
    }
    
    private int calculate(String s){
        // diff range: 0~25
        
        char c1 = s.charAt(s.length()-1);
        char c2 = s.charAt(0);
        
        int val = c1 - c2;
        
        if( val > 25){
            val = val - 26;
        }
        else if(val < 0){
            val = val + 26;
        }
        return val;
    }
}
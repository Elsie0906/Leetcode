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
        
        for(int i=0; i<strings.length; i++){
            //System.out.println("[Debug] str: " + strings[i]);
            
            len = strings[i].length();          
            
            if( !hm.containsKey(len) ){                        // <hashcode,idx>
                List<String> list = new ArrayList<>();
                list.add(strings[i]);
                arrList.add(list);
                hm.put(len, idx);                              // update
                idx++;
            }
            else{
                int index = hm.get(len);
                List<String> list = arrList.remove(index);
                boolean reVal = check(strings[i],list.get(0));
                
                //System.out.println("[Debug] reVal: " + reVal);
                if( reVal == true)
                {
                    list.add(strings[i]);
                    arrList.add(index, list);                    
                }           
                else{
                    arrList.add(index,list);
                    List<String> ll = new ArrayList<>();
                    ll.add(strings[i]);
                    arrList.add(ll);
                }
                
            }
        }
        
        return arrList;     // dummy
    }
    private boolean check(String str1, String str2){
        
        if( str1.length() == 1)
            return true;
        
        int diff1 = calculate(str1);
        int diff2 = calculate(str2);
        
        //System.out.println("[Debug] diff1: " + diff1 + ", diff2: " + diff2);
        
        return (diff1 == diff2);
    }
    private int calculate(String s){
        
        char c1 = s.charAt(s.length()-1);
        char c2 = s.charAt(0);
        
        int val = c2 - c1;
        
        //System.out.println("val: " + val);
        
        if( val > 25){
            val = val - 26;
        }
        else if(val <= -25){
            val = val + 26;
        }
        
        return val;
    }
}
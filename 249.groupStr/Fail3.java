/*
* failed case: ["ab","ba"]
* contains only lowercase alphabets
*/

class Solution {
    // hashcode: len << 3 + diff
    // <hashcode, idx>
    private class MyNode{
        private int len;
        private int diff;
        public MyNode(int x, int y){
            len = x;
            diff = y;
        }
        public boolean equals(Object o){
            
            MyNode node = (MyNode) o;
            
            return (this.len == node.len) && (this.diff == node.diff);
        }
        public int hashCode() {
            int result = 17;
            result = 31 * result + len;
            result = 31 * result + diff;
            return result;
        }
    }
    private HashMap<MyNode, Integer> hm = new HashMap<>();
    
    public List<List<String>> groupStrings(String[] strings) {
        
        List<List<String>> arrList = new ArrayList<>();
        
        int idx = 0, hashcode = -1;
        
        for(int i=0; i<strings.length; i++){
            //System.out.println("[Debug] str: " + strings[i]);
            
            MyNode node = new MyNode(strings[i].length(), calculate(strings[i]));       
            
            //System.out.println("[Debug] len: " + node.len + ", diff: " + node.diff);
            
            if( !hm.containsKey(node)){                        // < node,idx>
                List<String> list = new ArrayList<>();
                list.add(strings[i]);
                arrList.add(list);
                hm.put(node, idx);                              // update
                idx++;
            }
            else{
                int index = hm.get(node);
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
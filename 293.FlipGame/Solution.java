class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new LinkedList<String>();
        return helper(s, 0, s.length()-1, list);
        
    }
    
    private List<String> helper(String s, int start, int end, List<String> list){
        if( /*start > end ||*/ start+1 > end)
            return list;
        
        Character c1 = new Character(s.charAt(start));
        Character c2 = new Character(s.charAt(start+1));
        
        
        if( !c1.equals('+'))
            return helper(s,start+1, end, list);
        else if(!c2.equals('+'))
            return helper(s,start+2, end, list);
        
        String newS = "";
        
        if( start == 0){
            newS = "--" + s.substring(2,s.length());
            }
        else
            newS = s.substring(0,start) + "--" + s.substring(start+2,s.length());
        
          
        list.add(newS);
        
        return helper(s,start+1,end, list);
    }
}

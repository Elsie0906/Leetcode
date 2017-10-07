class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<Integer>();

        // Permutation
        List<List<String>> allList = new ArrayList<>();
        backtrack(allList, new ArrayList<>(), p);
        
        for(int i=0; i<allList.size(); i++){
            //System.out.println(allList.get(i));
            List<String> row = allList.get(i);
            //System.out.println(row);
            String ss = new String();
            for(int j=0; j<row.size(); j++){
                ss = ss + row.get(j);
            }
            
            int idx = s.indexOf(ss); // can only find the first occurance, exception: [abab], "ab"
            if( idx >= 0)
                list.add(idx);
        }
        
        //System.out.println("test: " + s.indexOf("abc"));
        //System.out.println("test: " + s.indexOf("bac"));
        
        return list;
    }
    
    public List<List<String>> permute(String ss) {
        List<List<String>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), ss);
        return list;
    }

    private void backtrack(List<List<String>> list, List<String> tempList, String ll){
        if(tempList.size() == ll.length()){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < ll.length(); i++){ 
                if(tempList.contains(Character.toString(ll.charAt(i)))) continue; 
                // element already exists, skip
                tempList.add(Character.toString(ll.charAt(i)));
                backtrack(list, tempList, ll);
                tempList.remove(tempList.size() - 1);
            }
        }
    }  
}
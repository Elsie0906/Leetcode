class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new LinkedList<Integer>();

        // Permutation
        List<List<String>> allList = new ArrayList<>();
        backtrack(allList, new ArrayList<>(), p);
        
        List<String> reList = new ArrayList<>();
        
        for(int i=0; i<allList.size(); i++){
            //System.out.println(allList.get(i));
            List<String> row = allList.get(i);
            //System.out.println(row);
            String ss = new String();
            for(int j=0; j<row.size(); j++){
                ss = ss + row.get(j);
            }
            reList.add(ss);       
        }
        
        //System.out.println("s.length: " + s.length() + ", p.length: " + p.length());
        for(int i=0; i<=s.length()-p.length(); i++){
            String str = s.substring(i,i+p.length());
            System.out.println("str: " + str);
            for(int j=0; j<reList.size();j++){
                String str2 = reList.get(j);
                System.out.println("str2: " + str2);
                if( str.equals(str2)){
                    list.add(i);
                    break;
                }        
            }
        }
        
        //System.out.println("test: " + s.indexOf("abc"));
        //System.out.println("test: " + s.indexOf("bac"));
        
        return list;
    }
    
    public List<List<String>> permute(String ss) { // no repeat character!!
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
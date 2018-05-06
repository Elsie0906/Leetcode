class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        //Dynamic Programming: space complexity O(N); time complexity O(N^2)
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // Initialization
        
        ArrayList<Integer> x0 = new ArrayList<Integer>(Arrays.asList(1));
        ArrayList<Integer> x1 = new ArrayList<Integer>(Arrays.asList(1,1));
        
        if(rowIndex == 0)   return x0;
        if(rowIndex == 1)   return x1;
        
        int loop = rowIndex;
        
        for(int i=2; i<=loop; i++){ // index = 3, only 2-loop needed
            
            int len = x1.size()+1;
            
            for(int j=0; j<len; j++){
                
                if(j==0){
                    list = new ArrayList<Integer>();
                    list.add(1);        // first node
                }
                else if(j==len-1){
                    list.add(1);        // last node
                    break;
                }
                else{
                    int temp = x1.get(j) + x1.get(j-1);
                    list.add(temp);                    
                }

            }    
            x1 = list;
            
        }
        
        
        return list;
    }
    
}
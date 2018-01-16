class Solution {
    
    public int findCircleNum(int[][] M) {
        
        int[] root = new int[M.length];
        
        // init; complexity: O(N)
        
        for(int i=0; i<root.length; i++){
            root[i] = i;
        }
        
        // check half the array; complexity: O(0.5 * N * N) * O(N) 
        for(int i=0; i<M.length; i++){
            for(int j=i+1; j<M.length; j++){
                
                if( M[i][j] == 1 && root[i] != root[j]){        // [need to improve] backtracking            
                    int target = -1, val = -1;
                    if( root[i] > root[j]){
                        target = root[i];
                        val = root[j];
                    }else{
                        target = root[j];
                        val = root[i];
                    } 
                    
                    for(int k=0; k<M.length; k++){
                        if( root[k] == target)
                            root[k] = val;
                    }
                }
                
            }
        }
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0; i<root.length; i++){
            hs.add(root[i]);
        }
        
        return hs.size();
    }
}
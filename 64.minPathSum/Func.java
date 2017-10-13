// complexity: O(mn)

class Solution {
    public int minPathSum(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        //System.out.println("m: " + m + " n: " + n);
        
        int[] temp = new int[m];
        
        // initialize
        temp[0] = grid[0][0];
        for(int j=1; j<m; j++){
            temp[j] = temp[j-1] + grid[0][j];
            //System.out.print(temp[j] + " ");
        }
        //System.out.println();
        
        // DP
        for(int i=1; i<n; i++){
            temp[0] = temp[0] + grid[i][0]; 
            for(int j=1; j<m; j++){
                temp[j] = Math.min(temp[j-1],temp[j]) + grid[i][j];
            }
        }
        
        // find minimum in an Array
        
        //System.out.println("min: " + temp[m-1]);
        
        
        return temp[m-1];
    }
}
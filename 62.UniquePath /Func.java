public class Solution {
    public int uniquePaths(int m, int n) {
        int result = 0;
        int[][] checkArray = new int[m][n]; 
/*        
        if( m==1 || n==1)
            return 1;
        
        return uniquePaths(m-1,n) + uniquePaths(m,n-1);
*/
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if( i==0 || j==0){
                    checkArray[i][j] = 1;
                }
                else{
                    checkArray[i][j] = checkArray[i-1][j] + checkArray[i][j-1];
                }
                
            }
        }
        
        result = checkArray[m-1][n-1];
        
        return result;
    }
}
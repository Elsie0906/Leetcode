// Greedy: local min

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];
        //System.out.println("layer: " + triangle.size() + " number: " + triangle.get(0).size());
        dp[0] = triangle.get(0).get(0);
        
        int min = helper(triangle, 0, 0, dp);
        
        //System.out.println("min: " + min);
        
        return min;
    }
    
    public int helper(List<List<Integer>> A, int idx, int layer, int[] dp){
        
        System.out.println("layer: " + layer + " index: " + idx + " dp: " + dp[layer]);
        
        layer ++;     
        
        if( layer == dp.length-1)
            return dp[layer-1];
        
        int left = idx;
        int right = idx + 1;
        
        int leftNum = A.get(layer).get(left);
        int rightNum = A.get(layer).get(right); 
        
        System.out.println("left: " + leftNum + "right: " + rightNum);
        
        if( leftNum < rightNum){
            dp[layer] = dp[layer-1] + leftNum;
            return helper(A, left, layer, dp);
        }
        else{
            dp[layer] = dp[layer-1] + rightNum;
            return helper(A, right, layer, dp);            
        }    
    
    }
}
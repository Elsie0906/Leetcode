public class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        
        for(int i=0; i<prices.length; i++){
            int max = -9999;
            int profit = -9999;
            for(int j=i+1; j<prices.length; j++){
                
                if(prices[j] <= prices[i])
                    break;
                
                profit = prices[j] - prices[i];
                if( profit > max ){
                    max = profit;
                }
                    
            //System.out.println("diff: "+ profit + ", local max: " + max);    
            }
            if( max > maxP ){
                maxP = max;
            }
            //System.out.println("update: "+ maxP); 
        }
        
        return maxP;
    }
}